package com.emrah.todolist.dto.todo.todoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllTodoResponseDto {
    private String userName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean done;
}
