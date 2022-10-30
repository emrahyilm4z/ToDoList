package com.emrah.todolist.dto.todo.todoRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TodoUpdateRequestDto {
    private int id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean done;
}
