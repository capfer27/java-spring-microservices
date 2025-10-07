package com.capfer.product_api.exception;

public class CategoryNotFoundException extends RuntimeException {

    private String message;

    public CategoryNotFoundException() {}

    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
