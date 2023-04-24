import org.hillel.homework9.config.StdoutLoggerConfigurationLoader;
import org.hillel.homework9.logger.Logger;
import org.hillel.homework9.logger.StdoutLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StdoutLoggerTest {

    ByteArrayOutputStream buffer;

    @BeforeEach
    void init() {
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

    }

    @Test
    void testLoggerLogInfoMessageLogLevelDebug() {

        Logger logger = new StdoutLogger(new StdoutLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        logger.info(Constants.MESSAGE);

        String logs = buffer.toString();
        assertTrue(logs.contains(Constants.INFO));
        assertTrue(logs.contains(Constants.MESSAGE));
    }

    @Test
    void testLoggerLogDebugMessageLogLevelDebug() {

        Logger logger = new StdoutLogger(new StdoutLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        logger.debug(Constants.MESSAGE);

        String logs = buffer.toString();
        assertTrue(logs.contains(Constants.DEBUG));
        assertTrue(logs.contains(Constants.MESSAGE));
    }

    @Test
    void testLoggerLogInfoMessageLogLevelInfo() {

        Logger logger =
                new StdoutLogger(new StdoutLoggerConfigurationLoader().load(Constants.LOGGER_PROPERTIES));

        logger.info(Constants.MESSAGE);

        String logs = buffer.toString();
        assertTrue(logs.contains(Constants.INFO));
        assertTrue(logs.contains(Constants.MESSAGE));
    }
}


