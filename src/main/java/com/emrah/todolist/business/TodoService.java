package com.emrah.todolist.business;

import com.emrah.todolist.dto.todo.todoRequest.TodoAddRequestDto;
import com.emrah.todolist.dto.todo.todoRequest.TodoUpdateRequestDto;
import com.emrah.todolist.dto.todo.todoResponse.AllTodoResponseDto;
import com.emrah.todolist.dto.todo.todoResponse.TodoResponseDto;
import com.emrah.todolist.entities.Todo;
import com.emrah.todolist.entities.User;
import com.emrah.todolist.exception.TodoNotFoundId;
import com.emrah.todolist.exception.UserNotFoundId;
import com.emrah.todolist.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto add(TodoAddRequestDto todoAddRequestDto) {
        User user = userService.findById(todoAddRequestDto.getUser_id());
        Todo todo = modelMapper.map(todoAddRequestDto, Todo.class);
        todo.setUser(user);
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoResponseDto.class);
    }

    public List<AllTodoResponseDto> getAll() {
        return todoRepository.findAll().stream().map(item -> {
            String userName = item.getUser().getName();
            return AllTodoResponseDto.builder()
                    .userName(userName)
                    .description(item.getDescription())
                    .startDate(item.getStartDate())
                    .endDate(item.getEndDate())
                    .done(item.isDone()).build();
        }).toList();

    }

    public boolean deleteTodo(int id) {
        todoRepository.findById(id).orElseThrow(TodoNotFoundId::new);
        todoRepository.deleteById(id);
        return !todoRepository.existsById(id);
    }

    public TodoResponseDto updateTodo(TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoUpdateRequestDto.getId()).orElseThrow(TodoNotFoundId::new);
        User user = userService.findById(todo.getUser().getId());
        todo = modelMapper.map(todoUpdateRequestDto, Todo.class);
        todo.setUser(user);
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoResponseDto.class);
    }

    private List<TodoResponseDto> getAllTodo() {
        return todoRepository.findAll().stream().map(item -> modelMapper.map(item, TodoResponseDto.class)).toList();
    }

    public List<TodoResponseDto> getDaily() {
        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR);
        return getAllTodo().stream().filter((item) -> item.getStartDate().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == dayOfYear).toList();
    }

    public List<TodoResponseDto> getWeekly() {
        LocalDate localDate = LocalDate.now();
        int weekOfYear = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        return getAllTodo().stream().filter((item) -> item.getStartDate().get(ChronoField.ALIGNED_WEEK_OF_YEAR) == weekOfYear).toList();
    }

    public List<TodoResponseDto> getMonthly() {
        LocalDate localDate = LocalDate.now();
        int monthOfYear = localDate.get(ChronoField.MONTH_OF_YEAR);
        return getAllTodo().stream().filter((item) -> item.getStartDate().get(ChronoField.MONTH_OF_YEAR) == monthOfYear).toList();
    }

    public List<TodoResponseDto> getNotDone() {
        return todoRepository.findByDoneIsFalse().stream().map(item -> modelMapper.map(item, TodoResponseDto.class)).toList();
    }

    public List<TodoResponseDto> getDone() {
        return todoRepository.findByDoneIsTrue().stream().map(item -> modelMapper.map(item, TodoResponseDto.class)).toList();
    }

    public TodoResponseDto done(int id) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundId::new);
        todo.setDone(!todo.isDone());
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoResponseDto.class);
    }
}
