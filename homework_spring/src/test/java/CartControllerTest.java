import Spring_project_1.controller.CartController;
import Spring_project_1.dto.ProductDTO;
import Spring_project_1.entity.Cart;
import Spring_project_1.entity.Product;
import Spring_project_1.mapper.ProductMapper;
import Spring_project_1.repository.ProductRepository;
import Spring_project_1.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CartControllerTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CartService cartService;

    @Mock
    private ProductMapper productMapper;

    private CartController cartController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cartController = new CartController(productRepository, cartService, productMapper);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", 10.0),
                new Product(2, "Product 2", 20.0)
        );

        when(productRepository.getAllProducts()).thenReturn(products);

        when(productMapper.toDTO(any(Product.class))).thenAnswer(invocation -> {
            Product product = invocation.getArgument(0);
            return new ProductDTO(product.getId(), product.getName(), product.getPrice());
        });

        List<ProductDTO> result = cartController.getAllProducts();

        Assertions.assertEquals(products.size(), result.size());
    }

    @Test
    public void testGetCartItems() {
        // Mock data
        Cart cart = new Cart();
        List<Product> items = Arrays.asList(
                new Product(1, "Product 1", 10.0),
                new Product(2, "Product 2", 20.0)
        );
        cart.setItems(items);

        when(cartService.getCart()).thenReturn(cart);

        when(productMapper.toDTO(any(Product.class))).thenAnswer(invocation -> {
            Product product = invocation.getArgument(0);
            return new ProductDTO(product.getId(), product.getName(), product.getPrice());
        });

        List<ProductDTO> result = cartController.getCartItems();

        Assertions.assertEquals(items.size(), result.size());
    }

    @Test
    public void testAddProductToCart() {
        ProductDTO productDTO = new ProductDTO(1, "Product 1", 10.0);
        Product product = new Product(1, "Product 1", 10.0);

        when(productMapper.toEntity(productDTO)).thenReturn(product);

        cartController.addProductToCart(productDTO);

        verify(cartService, times(1)).addProductToCart(eq(product));
    }

    @Test
    public void testDeleteProductFromCart() {
        int productId = 1;

        cartController.deleteProductFromCart(productId);

        verify(cartService, times(1)).removeProductFromCart(eq(productId));
    }
}