package com.stack.exception;

public class EmptyStackException extends RuntimeException{
    private final String message;


    public EmptyStackException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}