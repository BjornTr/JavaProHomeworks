package org.hillel.homework9.logger;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.hillel.homework9.config.FileLoggerConfiguration;
import org.hillel.homework9.config.FileLoggerConfigurationLoader;
import org.hillel.homework9.exception.FileMaxSizeReachedException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@AllArgsConstructor
public class FileLogger implements Logger {

    private final FileLoggerConfiguration configuration;
    private File file;

    @SneakyThrows
    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        Files.createDirectories(Paths.get(configuration.getPath()));
    }

    @SneakyThrows
    public FileLogger() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        this.configuration = loader.load();
        Files.createDirectories(Paths.get(configuration.getPath()));
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
    public void logMessage(String message) {
        if (Objects.isNull(file)) {
            file = new File(getLogName());
        }
        try {
            writeToFile(message, file);
        } catch (FileMaxSizeReachedException e) {
            file = new File(getLogName());
            writeToFile(message, file);
        }
    }

    private void writeToFile(String message, File file) throws IOException {

        if (Files.size(file.toPath()) > configuration.getMaxSize()) {
            throw new FileMaxSizeReachedException("File size is reached");
        }
    }

    public File getFile() {
        return file;
    }

    private String getLogName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss.SSS");
        return new StringBuilder()
                .append(this.configuration.getPath())
                .append("_")
                .append(formatter.format(LocalDateTime.now()))
                .append(".log")
                .append(this.configuration.getFormat())
                .toString();
    }
}