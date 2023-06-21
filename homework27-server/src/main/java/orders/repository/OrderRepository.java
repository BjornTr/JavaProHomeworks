package orders.repository;

import orders.entity.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderRepository {

    private final AtomicInteger nextID = new AtomicInteger(1);
    private final List<Order> orders = new LinkedList<>();

    public Order getByID(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("orders.entity.Order with ID " + id + " not found."));
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        int newID = nextID.getAndIncrement();
        Order newOrder = new Order(newID, order.getDate(), order.getCost(), order.getProducts());
        orders.add(newOrder);
    }
}