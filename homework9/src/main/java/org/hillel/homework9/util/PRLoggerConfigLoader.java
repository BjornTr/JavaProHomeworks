package org.hillel.homework9.util;
import java.io.IOException;
import java.util.Properties;

public class PRLoggerConfigLoader {

    private final static String CONFIG = "logger.properties";
    private final Properties properties;

    public PRLoggerConfigLoader() throws IOException {
        PropertyReader propertyReader = new PropertyReader();
        this.properties = propertyReader.getProperties(CONFIG);
    }

    public Properties getProperties() {
        return properties;
    }
}