import orders.entity.Order;
import orders.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orders.repository.OrderRepository;
import orders.service.OrderService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderService = new OrderService(orderRepository);
    }

    @Test
    void testGetById_ExistingOrder() {
        Order expectedOrder = new Order(1, LocalDate.now(), 10.0, List.of(new Product(1, "Product 1", 5.0)));

        orderRepository.addOrder(expectedOrder);
        Order actualOrder = orderService.getById(1);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testGetById_NonExistingOrder() {
        int nonExistingId = 100;

        assertThrows(IllegalArgumentException.class, () -> orderService.getById(nonExistingId));
    }

    @Test
    void testGetAllOrders() {
        Order order1 = new Order(1, LocalDate.now(), 10.0, List.of(new Product(1, "Product 1", 5.0)));
        Order order2 = new Order(2, LocalDate.now(), 30.0, List.of(new Product(2, "Product 2", 15.0)));

        orderRepository.addOrder(order1);
        orderRepository.addOrder(order2);

        List<Order> expectedOrders = List.of(order1, order2);
        List<Order> actualOrders = orderService.getAllOrders();

        assertEquals(expectedOrders, actualOrders);
    }
}
