package com.emrah.todolist.dto.user.userResponse;

import com.emrah.todolist.dto.todo.todoResponse.TodoResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllUserResponseDto {
    private String name;
    private List<TodoResponseDto> todos;
}
