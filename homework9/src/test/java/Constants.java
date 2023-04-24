import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constants {

    public final static String LOGGER_PROPERTIES = "logger.properties";

    public final static String DATE_MESSAGE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") .format(LocalDateTime.now());
    public final static String MESSAGE = "test message";
    public final static String ERROR = "ERROR";
    public final static String WARN = "WARN";
    public final static String INFO = "INFO";
    public final static String DEBUG = "DEBUG";

}

