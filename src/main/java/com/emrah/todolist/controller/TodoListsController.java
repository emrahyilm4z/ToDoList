package com.emrah.todolist.controller;

import com.emrah.todolist.business.TodoService;
import com.emrah.todolist.dto.todo.todoRequest.TodoAddRequestDto;
import com.emrah.todolist.dto.todo.todoRequest.TodoUpdateRequestDto;
import com.emrah.todolist.dto.todo.todoResponse.AllTodoResponseDto;
import com.emrah.todolist.dto.todo.todoResponse.TodoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoListsController {
    private TodoService todoService;

    @Autowired
    public TodoListsController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<TodoResponseDto> add(@RequestBody TodoAddRequestDto todoAddRequestDto) {
        return new ResponseEntity<>(todoService.add(todoAddRequestDto), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AllTodoResponseDto>> getAll() {
        return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTodo")
    public ResponseEntity<Boolean> deleteTodo(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(todoService.deleteTodo(id), HttpStatus.OK);
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<TodoResponseDto> updateTodo(@RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return new ResponseEntity<>(todoService.updateTodo(todoUpdateRequestDto), HttpStatus.OK);
    }

    @GetMapping("/getDaily")
    public ResponseEntity<List<TodoResponseDto>> getDaily() {
        return new ResponseEntity<>(todoService.getDaily(), HttpStatus.OK);
    }

    @GetMapping("/getWeekly")
    public ResponseEntity<List<TodoResponseDto>> getWeekly() {
        return new ResponseEntity<>(todoService.getWeekly(), HttpStatus.OK);
    }

    @GetMapping("/getMonthly")
    public ResponseEntity<List<TodoResponseDto>> getMonthly() {
        return new ResponseEntity<>(todoService.getMonthly(), HttpStatus.OK);
    }

    @GetMapping("/getNotDone")
    public ResponseEntity<List<TodoResponseDto>> getNotDone() {
        return new ResponseEntity<>(todoService.getNotDone(), HttpStatus.OK);
    }

    @GetMapping("/getDone")
    public ResponseEntity<List<TodoResponseDto>> getDone() {
        return new ResponseEntity<>(todoService.getDone(), HttpStatus.OK);
    }

    @PostMapping("/done")
    public ResponseEntity<TodoResponseDto> done(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(todoService.done(id), HttpStatus.OK);
    }
}
