import org.hillel.homework9.config.StdoutLoggerConfiguration;
import org.hillel.homework9.config.StdoutLoggerConfigurationLoader;
import org.hillel.homework9.logger.LoggingLevel;
import org.hillel.homework9.util.PropertyReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class StdoutLoggerConfigurationLoaderTest {

    private final static String LEVEL = "level";
    PropertyReader propertyReader = new PropertyReader();

    @Test
    void testFileLoggerConfigurationLoaderDefault() {

        StdoutLoggerConfiguration configuration = new StdoutLoggerConfigurationLoader().load();
        Assertions.assertEquals(LoggingLevel.DEBUG, configuration.getLevel());
    }

    @Test
    void testFileLoggerConfigurationLoader() {

        Properties properties = propertyReader.getProperties(Constants.LOGGER_PROPERTIES);

        StdoutLoggerConfiguration configuration =
                new StdoutLoggerConfigurationLoader().load(Constants.LOGGER_PROPERTIES);
        Assertions.assertEquals(properties.getProperty(LEVEL),
                configuration.getLevel().name().toUpperCase());
    }
}

