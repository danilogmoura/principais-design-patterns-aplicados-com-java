package com.github.danilogmoura.factory.logger;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public abstract class Logger {

    protected abstract LoggerPrint getLogger();

    public void log(String message) {
        var formattedMessage = String.format("%s [%s] - %s",
                LocalDateTime.now().format(ofPattern("yyyy-MM-dd HH:mm:ss")),
                this.getClass().getCanonicalName(),
                message);

        getLogger().print(formattedMessage);
    }
}
