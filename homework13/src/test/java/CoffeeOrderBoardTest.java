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
        Order order = new Order(1, "Alice");
        coffeeOrderBoard.addOrder(order);
        assertEquals(List.of(order), coffeeOrderBoard.getOrders());
    }

    @Test
    @DisplayName("addOrder should update order when order exists")
    void addOrder_shouldUpdateOrder_whenOrderExists() {
        Order order1 = new Order(1, "Alice");
        Order order2 = new Order(2, "Bob");
        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);

        Order updatedOrder = new Order(3, "Alice");
        coffeeOrderBoard.addOrder(updatedOrder);

        assertEquals(List.of(updatedOrder, order2), coffeeOrderBoard.getOrders());
    }

    @Test
    @DisplayName("addOrder should add order when order does not exist")
    void deliver_shouldRemoveOrder() {
        Order order1 = new Order(1, "Alice");
        Order order2 = new Order(2, "Bob");
        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);

        coffeeOrderBoard.deliver(1);

        assertEquals(List.of(order2), coffeeOrderBoard.getOrders());
    }

    @Test
    @DisplayName("displayOrders should return orders as string")
    void displayOrders_shouldReturnOrdersAsString() {
        Order order1 = new Order(1, "Alice");
        Order order2 = new Order(2, "Bob");
        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);

        String expected = "=============\nNum | Name\n1 | Alice\n2 | Bob\n";
        assertEquals(expected, coffeeOrderBoard.displayOrders());
    }

    @Test
    @DisplayName("getNextOrder should return first order")
    void getNextOrder_shouldReturnFirstOrder() {
        Order order1 = new Order(1, "Alice");
        Order order2 = new Order(2, "Bob");
        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);

        assertEquals(order1, coffeeOrderBoard.getNextOrder());
    }

    @Test
    @DisplayName("getNextOrder should return null when no orders")
    void getNextOrder_shouldReturnNull_whenNoOrders() {
        assertNull(coffeeOrderBoard.getNextOrder());
    }

    @Test
    @DisplayName("getOrders should return orders")
    void addOrder_shouldAddMultipleOrders() {

        Order order1 = new Order(1, CUSTOMER_NAMES[0]);
        Order order2 = new Order(2, CUSTOMER_NAMES[1]);
        Order order3 = new Order(3, CUSTOMER_NAMES[2]);

        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);
        coffeeOrderBoard.addOrder(order3);

        List<Order> expectedOrders = Arrays.asList(order1, order2, order3);
        List<Order> actualOrders = coffeeOrderBoard.getOrders();
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    @DisplayName("deliver should remove order when multiple orders")
    void deliver_shouldRemoveOrder_whenMultipleOrders() {

        Order order1 = new Order(1, CUSTOMER_NAMES[0]);
        Order order2 = new Order(2, CUSTOMER_NAMES[1]);
        Order order3 = new Order(3, CUSTOMER_NAMES[2]);
        coffeeOrderBoard.addOrder(order1);
        coffeeOrderBoard.addOrder(order2);
        coffeeOrderBoard.addOrder(order3);

        coffeeOrderBoard.deliver(2);

        List<Order> expectedOrders = Arrays.asList(order1, order3);
        List<Order> actualOrders = coffeeOrderBoard.getOrders();
        assertEquals(expectedOrders, actualOrders);
    }
}
