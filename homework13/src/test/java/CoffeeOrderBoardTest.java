import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CoffeeOrderBoardTest {

    private CoffeeOrderBoard coffeeOrderBoard;
    private static final String[] CUSTOMER_NAMES = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isabella", "Jack", "Kevin", "Liam", "Mia", "Noah",
            "Olivia", "William", "Ava", "James", "Sophia", "Benjamin", "Charlotte", "Elijah", "Amelia", "Lucas", "Harper", "Mason", "Evelyn", "Logan", "Aria", "Alexander", "Abigail"};

    @BeforeEach
    void setUp() {
        coffeeOrderBoard = new CoffeeOrderBoard();
    }

    @Test
    @DisplayName("addOrder should add order")
    void addOrder_shouldAddOrder() {
        coffeeOrderBoard.addOrder("Alice");
        assertEquals(List.of(new Order(1, "Alice")), coffeeOrderBoard.getOrders());
    }

    @Test
    @DisplayName("addOrder should update order when order exists")
    void addOrder_shouldUpdateOrder_whenOrderExists() {
        coffeeOrderBoard.addOrder("Alice");
        coffeeOrderBoard.addOrder("Bob");

        coffeeOrderBoard.addOrder("Alice");

        List<Order> expectedOrders = Arrays.asList(
                new Order(1, "Alice"),
                new Order(2, "Bob")
        );
        List<Order> actualOrders = coffeeOrderBoard.getOrders();
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    @DisplayName("deliver should remove order")
    void deliver_shouldRemoveOrder() {
        coffeeOrderBoard.addOrder("Alice");
        coffeeOrderBoard.addOrder("Bob");

        coffeeOrderBoard.deliver(1);

        assertEquals(List.of(new Order(2, "Bob")), coffeeOrderBoard.getOrders());
    }

    @Test
    @DisplayName("displayOrders should return orders as string")
    void displayOrders_shouldReturnOrdersAsString() {
        coffeeOrderBoard.addOrder("Alice");
        coffeeOrderBoard.addOrder("Bob");

        String expected = "=============\nNum | Name\n1 | Alice\n2 | Bob\n";
        assertEquals(expected, coffeeOrderBoard.displayOrders());
    }

    @Test
    @DisplayName("getNextOrder should return first order")
    void getNextOrder_shouldReturnFirstOrder() {
        coffeeOrderBoard.addOrder("Alice");
        coffeeOrderBoard.addOrder("Bob");

        assertEquals(new Order(1, "Alice"), coffeeOrderBoard.getNextOrder());
    }

    @Test
    @DisplayName("getNextOrder should return null when no orders")
    void getNextOrder_shouldReturnNull_whenNoOrders() {
        assertNull(coffeeOrderBoard.getNextOrder());
    }

    @Test
    @DisplayName("addOrder should add multiple orders")
    void addOrder_shouldAddMultipleOrders() {
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[0]);
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[1]);
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[2]);

        List<Order> expectedOrders = Arrays.asList(
                new Order(1, CUSTOMER_NAMES[0]),
                new Order(2, CUSTOMER_NAMES[1]),
                new Order(3, CUSTOMER_NAMES[2])
        );

        List<Order> actualOrders = coffeeOrderBoard.getOrders();
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    @DisplayName("deliver should remove order when multiple orders")
    void deliver_shouldRemoveOrder_whenMultipleOrders() {
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[0]);
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[1]);
        coffeeOrderBoard.addOrder(CUSTOMER_NAMES[2]);

        coffeeOrderBoard.deliver(2);

        List<Order> expectedOrders = Arrays.asList(
                new Order(1, CUSTOMER_NAMES[0]),
                new Order(3, CUSTOMER_NAMES[2])
        );

        List<Order> actualOrders = coffeeOrderBoard.getOrders();
        assertEquals(expectedOrders, actualOrders);
    }
}