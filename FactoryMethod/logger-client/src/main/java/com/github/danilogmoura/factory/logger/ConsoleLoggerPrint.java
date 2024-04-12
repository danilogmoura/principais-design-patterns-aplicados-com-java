package com.github.danilogmoura.factory.logger;

public class ConsoleLoggerPrint implements LoggerPrint {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
