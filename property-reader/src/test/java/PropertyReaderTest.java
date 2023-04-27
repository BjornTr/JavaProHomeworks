import java.io.IOException;
import java.util.Properties;

import org.hillel.PropertyReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropertyReaderTest {

    @Test
    void testReadingProperty() throws IOException {

        PropertyReader propertyReader = new PropertyReader();

        Properties properties = propertyReader.getProperties("config.properties");

        Assertions.assertEquals("pathToFileTest", properties.getProperty("file"));

    }

}

