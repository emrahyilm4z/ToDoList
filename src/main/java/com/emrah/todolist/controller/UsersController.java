package com.emrah.todolist.controller;

import com.emrah.todolist.business.UserService;
import com.emrah.todolist.dto.user.userRequest.UserAddRequestDto;
import com.emrah.todolist.dto.user.userRequest.UserUpdateRequestDto;
import com.emrah.todolist.dto.user.userResponse.AllUserResponseDto;
import com.emrah.todolist.dto.user.userResponse.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AllUserResponseDto>> getAll() {
        return new ResponseEntity<List<AllUserResponseDto>>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> add(@RequestBody UserAddRequestDto userAddRequestDto) {
        return new ResponseEntity<UserResponseDto>(userService.add(userAddRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public Boolean delete(@RequestParam(name = "id") int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserResponseDto> update(@RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        return new ResponseEntity<>(userService.update(userUpdateRequestDto), HttpStatus.OK);
    }
}
