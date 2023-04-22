package org.hillel.homework9.config;

import org.hillel.homework9.logger.LoggingLevel;
import org.hillel.homework9.util.PropertyReader;

import java.util.Properties;


public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {

    PropertyReader reader;

    public FileLoggerConfigurationLoader() {
        reader = new PropertyReader();
    }

    public FileLoggerConfiguration load() {
        return load("logger.properties");
    }

    public FileLoggerConfiguration load(String path) {

        Properties properties = reader.getProperties(path);

        return FileLoggerConfiguration.builder()
                .maxSize(Integer.parseInt(properties.getProperty("max-size")))
                .format(properties.getProperty("format"))
                .level(LoggingLevel.valueOf(properties.getProperty("level").toUpperCase()))
                .path(properties.getProperty("file"))
                .build();
    }
}


