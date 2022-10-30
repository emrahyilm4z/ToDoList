package com.emrah.todolist.exception;

public class UserNotFoundId extends RuntimeException{
    public UserNotFoundId() {
        super(Messages.ID_NOT_FOUND);
    }
}
