package com.capfer.product_api.exception;

public class ProductNotFoundException extends RuntimeException {

    private String message;

    public ProductNotFoundException() {}

    public ProductNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
