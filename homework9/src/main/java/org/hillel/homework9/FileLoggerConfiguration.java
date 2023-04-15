package org.hillel.homework9;

public class FileLoggerConfiguration {
    private String logFilePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String fileFormat;

    public FileLoggerConfiguration(String logFilePath, LoggingLevel loggingLevel, long maxFileSize, String fileFormat) {
        this.logFilePath = logFilePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}