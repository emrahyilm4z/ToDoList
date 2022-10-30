package com.emrah.todolist.exception;

public class TodoNotFoundId extends RuntimeException {
    public TodoNotFoundId() {
        super(Messages.ID_NOT_FOUND);
    }
}
