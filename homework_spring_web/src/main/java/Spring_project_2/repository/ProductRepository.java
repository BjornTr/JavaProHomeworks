package Spring_project_2.repository;

import Spring_project_2.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<ProductDTO> products;


    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new ProductDTO (1, "Product 1", 10.0));
        products.add(new ProductDTO (2, "Product 2", 20.0));
        products.add(new ProductDTO (3, "Product 3", 30.0));
    }

    public List<ProductDTO > getAllProducts() {
        return products;
    }

    public ProductDTO  getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}