package org.hillel.homework9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void log(String message, LoggingLevel level) throws IOException {
        if (level.ordinal() > config.getLoggingLevel().ordinal()) {
            return;
        }

        String logFilePath = config.getLogFilePath();
        long maxFileSize = config.getMaxFileSize();
        String fileFormat = config.getFileFormat();

        String formattedMessage = String.format(fileFormat, level, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(formattedMessage);
            writer.newLine();
        }

        if (maxFileSize > 0 && getFileSize(logFilePath) > maxFileSize) {
            rotateLogFile(logFilePath);
        }
    }

    private long getFileSize(String filePath) {
        File file = new File(filePath);
        return file.length();
    }

    private void rotateLogFile(String filePath) throws IOException {
        String archiveFilePath = getArchiveFilePath(filePath);
        Path path = Paths.get(filePath);
        Files.move(path, Paths.get(archiveFilePath));
        Files.createFile(path);
    }

    private String getArchiveFilePath(String filePath) {
        File file = new File(filePath);
        String parentDir = file.getParent();
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        String extension = "";
        if (dotIndex != -1) {
            extension = fileName.substring(dotIndex);
            fileName = fileName.substring(0, dotIndex);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
        String timestamp = dateFormat.format(new Date());
        return parentDir + File.separator + "Log_" + timestamp + extension;
    }
}