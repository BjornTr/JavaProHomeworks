import Spring_project_1.entity.Product;
import Spring_project_1.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = new ProductRepository();
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productRepository.getAllProducts();

        Assertions.assertEquals(3, products.size());
    }

    @Test
    public void testGetProductById() {
        Product product = productRepository.getProductById(2);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(2, product.getId());
        Assertions.assertEquals("Product 2", product.getName());
        Assertions.assertEquals(20.0, product.getPrice());
    }

    @Test
    public void testGetProductById_NotFound() {
        Product product = productRepository.getProductById(4);

        Assertions.assertNull(product);
    }
}