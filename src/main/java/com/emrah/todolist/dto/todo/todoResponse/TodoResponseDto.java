package com.emrah.todolist.dto.todo.todoResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDto {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean done;

}
