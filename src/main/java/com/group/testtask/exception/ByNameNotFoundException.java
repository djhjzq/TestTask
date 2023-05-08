package com.group.testtask.exception;

public class ByNameNotFoundException extends RuntimeException {
    public ByNameNotFoundException() {
    }

    public ByNameNotFoundException(String message) {
        super(message);
    }
}
