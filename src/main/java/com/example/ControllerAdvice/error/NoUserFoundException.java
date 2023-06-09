package com.example.ControllerAdvice.error;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException(String message){
        super(message);
    }
}
