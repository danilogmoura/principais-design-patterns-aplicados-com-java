package com.github.danilogmoura.factory.logger;

public class ConsoleLogger extends Logger {

    @Override
    protected LoggerPrint getLogger() {
        return new ConsoleLoggerPrint();
    }
}
