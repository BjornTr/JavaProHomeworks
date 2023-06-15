import coffee.order.CoffeeOrderBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoffeeOrderBoardTest {
    private CoffeeOrderBoard coffeeOrderBoard;

    @BeforeEach
    void setUp() {
        coffeeOrderBoard = new CoffeeOrderBoard();
    }

    @Test
    void testAddOrder() {
        coffeeOrderBoard.addOrder("Order 1");
        coffeeOrderBoard.addOrder("Order 2");
        coffeeOrderBoard.addOrder("Order 1");

        String expectedOutput = """
                        =================
                        Number | Name
                        =================
                        2 | Order 2
                        3 | Order 1
                        """;
        assertEquals(expectedOutput, coffeeOrderBoard.draw());
    }

    @Test
    void testDeliver() {
        coffeeOrderBoard.addOrder("Order 1");
        coffeeOrderBoard.addOrder("Order 2");
        coffeeOrderBoard.addOrder("Order 3");

        coffeeOrderBoard.deliver(2);

        String expectedOutput = """
                        =================
                        Number | Name
                        =================
                        1 | Order 1
                        3 | Order 3
                        """;
        assertEquals(expectedOutput, coffeeOrderBoard.draw());
    }

    @Test
    void testDeliverInvalidOrder() {
        coffeeOrderBoard.addOrder("Order 1");
        coffeeOrderBoard.addOrder("Order 2");

        assertThrows(IllegalArgumentException.class, () -> coffeeOrderBoard.deliver(3));

        String expectedOutput = """
                =================
                Number | Name
                =================
                1 | Order 1
                2 | Order 2
                """;
        assertEquals(expectedOutput, coffeeOrderBoard.draw());
    }

    @Test
    void testDeliverNextOrder() {
        coffeeOrderBoard.addOrder("Order 1");
        coffeeOrderBoard.addOrder("Order 2");
        coffeeOrderBoard.addOrder("Order 3");

        coffeeOrderBoard.deliverNextOrder();

        String expectedOutput = """
                =================
                Number | Name
                =================
                2 | Order 2
                3 | Order 3
                """;
        assertEquals(expectedOutput, coffeeOrderBoard.draw());
    }

    @Test
    void testDraw() {
        coffeeOrderBoard.addOrder("Order 1");
        coffeeOrderBoard.addOrder("Order 2");
        coffeeOrderBoard.addOrder("Order 3");

        String expectedOutput = """
                =================
                Number | Name
                =================
                1 | Order 1
                2 | Order 2
                3 | Order 3
                """;
        assertEquals(expectedOutput, coffeeOrderBoard.draw());
    }
}