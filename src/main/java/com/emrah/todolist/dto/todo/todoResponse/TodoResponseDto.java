package com.emrah.todolist.dto.todo.todoResponse;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TodoResponseDto {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean done;

}
