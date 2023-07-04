package Spring_project_2.mapper;

import Spring_project_2.dto.OrderDTO;
import Spring_project_2.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final ProductMapper productMapper;

    @Autowired
    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderDTO toDto(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getDate(),
                order.getCost(),
                productMapper.toDtoList(order.getProducts())
        );
    }

    public Order toEntity(OrderDTO orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getDate(),
                orderDto.getCost(),
                productMapper.toEntityList(orderDto.getProducts())
        );
    }

    public List<OrderDTO> toDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Order> toEntityList(List<OrderDTO> orderDtos) {
        return orderDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}