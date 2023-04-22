package org.hillel.homework9.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    public static String formatMessage(String message, LoggingLevel ll) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss.SSS");

        return new StringBuilder()
                .append("[")
                .append(formatter.format(LocalDateTime.now()))
                .append("][")
                .append(ll.toString())
                .append("] Message: [")
                .append(message)
                .append("]")
                .toString();
    }
}

