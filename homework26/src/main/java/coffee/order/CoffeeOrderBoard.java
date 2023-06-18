package coffee.order;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CoffeeOrderBoard {

    private final List<Order> orders = new LinkedList<>();

    public void addOrder(String name) {
        log.info("Adding order: {}", name);

        Optional<Order> existingOrder = orders.stream()
                .filter(order -> order.name().equals(name))
                .findFirst();

        if (existingOrder.isPresent()) {
            Order orderToRemove = existingOrder.get();
            orders.remove(orderToRemove);
            log.info("Existing order removed: {}", orderToRemove);
        }

        int newNumber = getNextFreeNumber();
        Order newOrder = new Order(name, newNumber);
        orders.add(newOrder);
        log.info("New order added: {}", newOrder);
    }

    public void deliverNextOrder() {
        log.info("Delivering next order");

        if (orders.isEmpty()) {
            log.error("No orders in the queue");
            throw new IllegalStateException("No orders in the queue");
        }

        Order removedOrder = orders.remove(0);
        log.info("Order delivered: {}", removedOrder);
    }

    public void deliver(int orderNumber) {
        log.info("Delivering order by number: {}", orderNumber);

        Optional<Order> orderToRemove = orders.stream()
                .filter(order -> order.number() == orderNumber)
                .findFirst();

        if (orderToRemove.isPresent()) {
            orders.remove(orderToRemove.get());
            log.info("Order removed successfully: {}", orderToRemove.get());
        } else {
            log.error("Order not found: {}", orderNumber);
            throw new IllegalArgumentException("Order not found: " + orderNumber);
        }
    }

    public String draw() {
        log.info("Drawing the order list");
        StringBuilder sb = new StringBuilder();
        sb.append("=================\n");
        sb.append("Number | Name\n");
        sb.append("=================\n");

        for (Order order : orders) {
            sb.append(order.number()).append(" | ").append(order.name()).append("\n");
        }

        log.info("List drawn successfully");
        return sb.toString();
    }

    private int getNextFreeNumber() {
        int maxNumber = orders.stream()
                .mapToInt(Order::number)
                .max()
                .orElse(0);

        return maxNumber + 1;
    }
}
