package com.example.demo.exception;

public class ConflictException extends RuntimeException {

    // Default constructor
    public ConflictException() {
        super();
    }

    // Constructor with custom message
    public ConflictException(String message) {
        super(message);
    }
}
