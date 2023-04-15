package org.hillel.homework9;

import java.io.IOException;

public class Logger {
    private final FileLogger fileLogger;
    private final FileLoggerConfiguration fileLoggerConfiguration;

    public Logger(FileLoggerConfiguration config) throws IOException {
        fileLoggerConfiguration = config;
        fileLogger = new FileLogger(fileLoggerConfiguration);
    }

    public void info(String message) throws IOException {
        fileLogger.log(message, LoggingLevel.INFO);
    }

    public void debug(String message) throws IOException {
        fileLogger.log(message, LoggingLevel.DEBUG);
    }
}