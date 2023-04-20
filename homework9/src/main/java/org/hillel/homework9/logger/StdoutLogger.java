package org.hillel.homework9.logger;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.hillel.homework9.config.LoggerConfiguration;
import org.hillel.homework9.config.StdoutLoggerConfiguration;
import org.hillel.homework9.config.StdoutLoggerConfigurationLoader;

@Setter
@AllArgsConstructor
public class StdoutLogger implements Logger {

    private final StdoutLoggerConfiguration configuration;

    public StdoutLogger() {
        this.configuration = (StdoutLoggerConfiguration) new StdoutLoggerConfigurationLoader().load();
    }

    public StdoutLogger(LoggerConfiguration configuration) {
        this.configuration = (StdoutLoggerConfiguration) configuration;
    }

    public void error(String message) {
        if (configuration.getLevel().ordinal() == LoggingLevel.ERROR.ordinal()) {
            logMessage(LoggerUtil.formatMessage(message, LoggingLevel.ERROR));
        }
    }

    public void warn(String message) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.WARN.ordinal()) {
            logMessage(LoggerUtil.formatMessage(message, LoggingLevel.WARN));
        }
    }

    public void info(String message) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.INFO.ordinal()) {
            logMessage(LoggerUtil.formatMessage(message, LoggingLevel.INFO));
        }
    }

    public void debug(String message) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            logMessage(LoggerUtil.formatMessage(message, LoggingLevel.DEBUG));
        }
    }

    @SneakyThrows
    private void logMessage(String message) {
        System.out.println(message);
    }
}
