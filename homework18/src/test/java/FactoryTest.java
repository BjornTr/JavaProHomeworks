import factory.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    void testAbstractFactory() {
        AbstractFactory abstractFactory = new AbstractFactory();

        Factory furnitureFactory = abstractFactory.getFactory("furniture");
        assertNotNull(furnitureFactory);
        assertTrue(furnitureFactory instanceof FurnitureFactory);

        Factory carFactory = abstractFactory.getFactory("car");
        assertNotNull(carFactory);
        assertTrue(carFactory instanceof CarFactory);
    }

    @Test
    void testFurnitureFactory() {
        FurnitureFactory furnitureFactory = new FurnitureFactory();

        Furniture chair = furnitureFactory.build("Chair");
        assertTrue(chair instanceof Chair);

        Furniture table = furnitureFactory.build("Table");
        assertTrue(table instanceof Table);

        Furniture sofa = furnitureFactory.build("Sofa");
        assertTrue(sofa instanceof Sofa);

        Furniture defaultFurniture = furnitureFactory.build("InvalidType");
        assertNotNull(defaultFurniture);
    }

    @Test
    void testCarFactory() {
        CarFactory carFactory = new CarFactory();

        Car bmw = carFactory.build("BMW");
        assertTrue(bmw instanceof BMW);

        Car toyota = carFactory.build("Toyota");
        assertTrue(toyota instanceof Toyota);

        Car defaultCar = carFactory.build("InvalidType");
        assertNotNull(defaultCar);
    }
}
