import org.hillel.homework9.config.FileLoggerConfiguration;
import org.hillel.homework9.config.FileLoggerConfigurationLoader;
import org.hillel.homework9.util.PropertyReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class FileLoggerConfigurationLoaderTest {

    private final static String FILE = "file";
    private final static String MAX_SIZE = "max-size";
    private final static String FORMAT = "format";
    private final static String LEVEL = "level";
    PropertyReader propertyReader = new PropertyReader();

    @Test
    void testFileLoggerConfigurationLoaderDefault() {

        Properties properties = propertyReader.getProperties(Constants.LOGGER_PROPERTIES);

        FileLoggerConfiguration configuration = new FileLoggerConfigurationLoader().load();
        Assertions.assertEquals(properties.getProperty(FILE), configuration.getPath());
        Assertions.assertEquals(Integer.valueOf(properties.getProperty(MAX_SIZE)), configuration.getMaxSize());
        Assertions.assertEquals(properties.getProperty(FORMAT), configuration.getFormat());
        Assertions.assertEquals(properties.getProperty(LEVEL), configuration.getLevel().name().toUpperCase());
    }

    @Test
    void testFileLoggerConfigurationLoader() {

        Properties properties = propertyReader.getProperties(Constants.LOGGER_PROPERTIES);

        FileLoggerConfiguration configuration = new FileLoggerConfigurationLoader().load(Constants.LOGGER_PROPERTIES);
        Assertions.assertEquals(properties.getProperty(FILE), configuration.getPath());
        Assertions.assertEquals(Integer.valueOf(properties.getProperty(MAX_SIZE)), configuration.getMaxSize());
        Assertions.assertEquals(properties.getProperty(FORMAT), configuration.getFormat());
        Assertions.assertEquals(properties.getProperty(LEVEL), configuration.getLevel().name().toUpperCase());
    }
}


