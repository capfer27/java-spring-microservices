package com.capfer.user_api.exception;

public class UserNotFoundException extends RuntimeException {

    private String message;

    public UserNotFoundException() {}

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
