package com.example.exceptions;

public class ProfileNotFoundExceptions extends RuntimeException {
    public ProfileNotFoundExceptions(String message) {
        super(message);
    }
}
