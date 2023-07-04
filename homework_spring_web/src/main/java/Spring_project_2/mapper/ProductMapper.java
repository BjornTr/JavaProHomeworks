package Spring_project_2.mapper;

import Spring_project_2.dto.ProductDTO;
import Spring_project_2.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDTO toDto(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getCost());
    }

    public Product toEntity(ProductDTO productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getCost());
    }

    public List<ProductDTO> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Product> toEntityList(List<ProductDTO> productDtos) {
        return productDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}