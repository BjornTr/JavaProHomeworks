package orders.service;

import orders.entity.Order;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.NoArgsConstructor;
import orders.repository.OrderRepository;

import java.util.List;

@NoArgsConstructor
@WebService
public class OrderService extends OrderRepository {

    private OrderRepository orderRepository = new OrderRepository();

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @WebMethod
    public Order getById(int id) {
        return orderRepository.getByID(id);
    }

    @WebMethod
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @WebMethod
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
