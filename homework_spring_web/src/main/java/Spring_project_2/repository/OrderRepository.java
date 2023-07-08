package Spring_project_2.repository;

import Spring_project_2.dto.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private final Map<UUID, OrderDTO> orders = new HashMap<>();

    public OrderDTO getOrderById(UUID id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        throw new IllegalArgumentException("Order with ID " + id + " doesn't exist");
    }

    public List<OrderDTO> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void addOrder(OrderDTO orderDto) {
        UUID orderId = UUID.randomUUID();

        if (orders.containsKey(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " already exists");
        }

        orderDto.setId(orderId);
        orders.put(orderId, orderDto);
    }

    public void deleteOrder(UUID id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
        } else {
            throw new IllegalArgumentException("Order with ID " + id + " doesn't exist");
        }
    }

    public OrderDTO updateOrder(OrderDTO orderDto) {
        UUID orderId = orderDto.getId();

        if (orders.containsKey(orderId)) {
            OrderDTO currentOrder = orders.get(orderId);
            currentOrder.setDate(orderDto.getDate());
            currentOrder.setCost(orderDto.getCost());
            currentOrder.setProducts(orderDto.getProducts());

            return currentOrder;
        } else {
            throw new IllegalArgumentException("Order with ID " + orderId + " doesn't exist");
        }
    }

    public void clear() {
        orders.clear();
    }
}