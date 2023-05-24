import strategy.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {

    @Test
    void testRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 5);
        double expectedArea = 4 * 5;
        assertEquals(expectedArea, rectangle.getArea());
    }

    @Test
    void testTriangleArea() {
        Triangle triangle = new Triangle(3, 6);
        double expectedArea = 0.5 * 3 * 6;
        assertEquals(expectedArea, triangle.getArea());
    }
}
