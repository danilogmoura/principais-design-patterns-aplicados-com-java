package com.github.danilogmoura.factory.servico;

public class InstanceCreationException extends RuntimeException {
    public InstanceCreationException(String message) {
        super(message);
    }

    public InstanceCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
