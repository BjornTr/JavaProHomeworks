package service;

import entity.Order;
import repository.OrderRepository;

import java.util.Map;
import java.util.UUID;

public class OrderService {

    private final OrderRepository orderRepository = new OrderRepository();

    public Order addOrder(Order order) {
        return orderRepository.addOrder(order);
    }

    public Order getByID(UUID id) {
        return orderRepository.getByID(id);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteOrder(id);
    }

    public Order updateOrder(Order order) {
        return orderRepository.updateOrder(order);
    }

    public Map<UUID, Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public void clear() {
        orderRepository.clear();
    }
}