package com.org.users.exceptions;

public class DuplicateMailException extends RuntimeException {

    public DuplicateMailException() {
    }

    public DuplicateMailException(String message) {
        super(message);
    }

}
