import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {
    private final List<Order> orders = new LinkedList<>();
    private int orderNumber = 1;

    public void addOrder(String name) {
        for (int i = 0; i < orders.size(); i++) {
            Order existingOrder = orders.get(i);
            if (existingOrder.getName().equals(name)) {
                Order updatedOrder = new Order(existingOrder.getOrderNumber(), name);
                orders.set(i, updatedOrder);
                return;
            }
        }
        orders.add(new Order(orderNumber++, name));
    }

    public void deliver(int orderNumber) {
        orders.removeIf(order -> order.getOrderNumber() == orderNumber);
    }

    public String displayOrders() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============\n");
        sb.append("Num | Name\n");
        orders.stream()
                .sorted(Comparator.comparingInt(Order::getOrderNumber))
                .forEach(order -> sb.append(order.getOrderNumber()).append(" | ").append(order.getName()).append("\n"));
        return sb.toString();
    }

    public Order getNextOrder() {
        if (orders.isEmpty()) {
            return null;
        } else {
            return orders.get(0);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
