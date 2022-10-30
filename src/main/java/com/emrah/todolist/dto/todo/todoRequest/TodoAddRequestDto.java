package com.emrah.todolist.dto.todo.todoRequest;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class TodoAddRequestDto {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean done;
    private int user_id;
}
