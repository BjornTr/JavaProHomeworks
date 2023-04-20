package org.hillel.homework9.config;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.hillel.homework9.logger.LoggingLevel;

@Getter
@SuperBuilder
public abstract class LoggerConfiguration {
    private LoggingLevel level;

}