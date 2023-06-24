package repository;

import entity.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderRepository {

    private final Map<UUID, Order> orders = new HashMap<>();

    public Order getByID(UUID id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        throw new IllegalArgumentException("Order with ID " + id + " doesn't exist");
    }

    public Map<UUID, Order> getAllOrders() {
        return orders;
    }

    public Order addOrder(Order order) {
        UUID orderId = UUID.randomUUID();

        if (orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " already exists");
        }

        order.setId(orderId);
        orders.put(orderId, order);
        return order;
    }

    public void deleteOrder(UUID id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
        } else {
            throw new IllegalArgumentException("Order with ID " + id + " doesn't exist");
        }
    }

    public Order updateOrder(Order order) {
        UUID orderId = order.getId();

        if (orders.containsKey(orderId)) {
            Order currentOrder = orders.get(orderId);
            currentOrder.setDate(order.getDate());
            currentOrder.setCost(order.getCost());
            currentOrder.setProducts(order.getProducts());

            return currentOrder;
        } else {
            throw new IllegalArgumentException("Order with ID " + orderId + " doesn't exist");
        }
    }

    public void clear() {
        orders.clear();
    }
}