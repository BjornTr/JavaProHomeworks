package Spring_project_2.controller;

import Spring_project_2.dto.OrderDTO;
import Spring_project_2.mapper.OrderMapper;
import Spring_project_2.repository.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Data
@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderController(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @GetMapping()
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.getAllOrders());
        return "orders/all";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("order", orderRepository.getOrderById(id));
        return "orders/byId";
    }

    @GetMapping("/new")
    public String newOrder(@ModelAttribute("order") OrderDTO orderDto) {
        return "orders/new";
    }

    @PostMapping
    public String addOrder(@ModelAttribute("order") OrderDTO orderDto) {
        orderRepository.addOrder(orderDto);
        return "redirect:/orders";
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") UUID id) {
        orderRepository.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable("id") UUID id, @RequestBody OrderDTO orderDto) {
        orderDto.setId(id);
        return orderRepository.updateOrder(orderDto);
    }

    @PostMapping("/clear")
    public void clearOrders() {
        orderRepository.clear();
    }
}