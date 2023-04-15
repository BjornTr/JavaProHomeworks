package org.hillel.homework9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String filePath) throws IOException {
        String file = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] lines = file.split("\n");

        String logFilePath = null;
        LoggingLevel loggingLevel = null;
        long maxFileSize = -1;
        String fileFormat = null;

        for (String line : lines) {
            String[] parts = line.split(":");
            String key = parts[0].trim();
            String value = parts[1].trim();

            switch (key) {
                case "log_file_path" -> logFilePath = value;
                case "logging_level" -> loggingLevel = LoggingLevel.valueOf(value);
                case "max_file_size" -> maxFileSize = Long.parseLong(value);
                case "file_format" -> fileFormat = value;
            }
        }

        return new FileLoggerConfiguration(logFilePath, loggingLevel, maxFileSize, fileFormat);
    }
}