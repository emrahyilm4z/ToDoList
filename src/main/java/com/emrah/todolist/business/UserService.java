package com.emrah.todolist.business;

import com.emrah.todolist.dto.todo.todoResponse.TodoResponseDto;
import com.emrah.todolist.dto.user.userRequest.UserAddRequestDto;
import com.emrah.todolist.dto.user.userRequest.UserUpdateRequestDto;
import com.emrah.todolist.dto.user.userResponse.AllUserResponseDto;
import com.emrah.todolist.dto.user.userResponse.UserResponseDto;
import com.emrah.todolist.entities.Todo;
import com.emrah.todolist.entities.User;
import com.emrah.todolist.exception.UserNotFoundId;
import com.emrah.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;


    public UserResponseDto add(UserAddRequestDto userAddRequestDto) {
        User user = modelMapper.map(userAddRequestDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public List<AllUserResponseDto> getAll() {
        return userRepository.findAll().stream().map(
                user -> AllUserResponseDto.builder()
                        .name(user.getName())
                        .todos(user.getTodo().stream().map(t -> modelMapper.map(t, TodoResponseDto.class)).toList()
                        ).build()
        ).toList();
    }

    public Boolean deleteUser(int id) {
        userRepository.findById(id).orElseThrow(UserNotFoundId::new);
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    public UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userUpdateRequestDto.getId()).orElseThrow(UserNotFoundId::new);
        user.setName(userUpdateRequestDto.getName());
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundId::new);
    }
}
