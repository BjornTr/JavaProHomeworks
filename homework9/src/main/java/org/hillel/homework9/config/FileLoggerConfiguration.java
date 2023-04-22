package org.hillel.homework9.config;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class FileLoggerConfiguration extends LoggerConfiguration {
    int maxSize;
    String path;
    String format;
}