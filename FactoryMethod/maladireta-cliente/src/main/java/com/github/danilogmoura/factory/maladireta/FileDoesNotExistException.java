package com.github.danilogmoura.factory.maladireta;

public class FileDoesNotExistException extends RuntimeException {

    public FileDoesNotExistException(String message) {
        super(message);
    }
}
