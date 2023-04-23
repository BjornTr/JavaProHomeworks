import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.hillel.homework9.config.FileLoggerConfigurationLoader;
import org.hillel.homework9.logger.FileLogger;
import org.hillel.homework9.logger.Logger;
import org.hillel.homework9.util.PropertyReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoggerTest {

    private final static String FILE = "file";
    private final static String FILTER = "log*.log";

    private PropertyReader propertyReader;
    private Properties properties;
    private String logDirectory;

    @BeforeEach
    void setUp() {
        propertyReader = new PropertyReader();
        properties = propertyReader.getProperties(Constants.LOGGER_PROPERTIES);
        logDirectory = properties.getProperty(FILE);
    }


    @Test
    void testLoggerCreateNewFiles() {

        System.out.println("test 1");
        Logger fileLogger = new FileLogger(new FileLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));

        for (int i = 0; i < 1; i++) {
            fileLogger.error(Constants.DATE_MESSAGE + " № " + i);
            fileLogger.warn(Constants.DATE_MESSAGE + " № " + i);
            fileLogger.info(Constants.DATE_MESSAGE + " № " + i);
            fileLogger.debug(Constants.DATE_MESSAGE + " № " + i);
        }

        Collection<File> files =
                FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                        TrueFileFilter.TRUE);

        assertTrue(files.size() > 0);
    }

    @Test
    void testLoggerLogInfoMessageLogLevelDebug() throws IOException {

        System.out.println("test 2");
        Logger fileLogger = new FileLogger(new FileLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        fileLogger.info(Constants.DATE_MESSAGE);

        Collection<File> files = FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                TrueFileFilter.TRUE);

        assertEquals(1, files.size());

        for (File file : files) {
            String logs = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            assertTrue(logs.contains(Constants.INFO));
            assertTrue(logs.contains(Constants.DATE_MESSAGE));
        }
    }

    @Test
    void testLoggerLogDebugMessageLogLevelDebug() throws IOException {

        System.out.println("test 3");
        Logger fileLogger = new FileLogger(new FileLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        fileLogger.debug(Constants.DATE_MESSAGE);

        Collection<File> files = FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                TrueFileFilter.TRUE);

        assertEquals(1, files.size());

        for (File file : files) {
            String logs = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            assertTrue(logs.contains(Constants.DEBUG));
            assertTrue(logs.contains(Constants.DATE_MESSAGE));
        }

    }

    @Test
    void testLoggerLogWarnMessageLogLevelDebug() throws IOException {

        System.out.println("test 4");
        Logger fileLogger = new FileLogger(new FileLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        fileLogger.warn(Constants.DATE_MESSAGE);

        Collection<File> files = FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                TrueFileFilter.TRUE);

        assertEquals(1, files.size());

        for (File file : files) {
            String logs = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            assertTrue(logs.contains(Constants.WARN));
            assertTrue(logs.contains(Constants.DATE_MESSAGE));
        }
    }

    @Test
    void testLoggerLogErrorMessageLogLevelDebug() throws IOException {

        System.out.println("test 5");
        Logger fileLogger = new FileLogger(new FileLoggerConfigurationLoader()
                .load(Constants.LOGGER_PROPERTIES));
        fileLogger.error(Constants.DATE_MESSAGE);

        Collection<File> files = FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                TrueFileFilter.TRUE);

        assertEquals(1, files.size());

        for (File file : files) {
            String logs = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            assertTrue(logs.contains(Constants.ERROR));
            assertTrue(logs.contains(Constants.DATE_MESSAGE));
        }

    }


    @Test
    void testLoggerLogErrorMessageLogLevelInfo() throws IOException {

        System.out.println("test 6");
        Logger fileLogger = new
                FileLogger(new FileLoggerConfigurationLoader().load(Constants.LOGGER_PROPERTIES));
        fileLogger.error(Constants.DATE_MESSAGE);

        Collection<File> files = FileUtils.listFiles(new File(logDirectory), new WildcardFileFilter(FILTER),
                TrueFileFilter.TRUE);

        assertEquals(1, files.size());

        for (File file : files) {
            String logs = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            assertTrue(logs.contains(Constants.ERROR));
            assertTrue(logs.contains(Constants.DATE_MESSAGE));
        }
    }


}



