import builder.Car;
import builder.CarBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarBuilderTest {
    @Test
    void testCarBuilder() {
        Car car = new CarBuilder()
                .engine("V6")
                .wheels("Alloy")
                .body("Sedan")
                .build();

        assertEquals("V6", car.engine());
        assertEquals("Alloy", car.wheels());
        assertEquals("Sedan", car.body());
    }
}
