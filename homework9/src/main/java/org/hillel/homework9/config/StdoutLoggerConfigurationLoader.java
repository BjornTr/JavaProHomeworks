package org.hillel.homework9.config;

import org.hillel.homework9.logger.LoggingLevel;
import org.hillel.homework9.util.PropertyReader;

import java.util.Properties;

public class StdoutLoggerConfigurationLoader implements LoggerConfigurationLoader {


    PropertyReader reader;

    public StdoutLoggerConfigurationLoader() {
        reader = new PropertyReader();
    }

    public LoggerConfiguration load() {
        return StdoutLoggerConfiguration.builder()
                .level(LoggingLevel.DEBUG)
                .build();
    }

    public LoggerConfiguration load(String path) {
        Properties properties = reader.getProperties(path);
        return StdoutLoggerConfiguration.builder()
                .level(LoggingLevel.valueOf(properties.getProperty("level")))
                .build();

    }
}


