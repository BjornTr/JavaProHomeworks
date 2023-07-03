import Spring_project_1.dto.ProductDTO;
import Spring_project_1.repository.CartDao;
import Spring_project_1.repository.ProductRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class DataBaseTest {

    private CartDao cartDao;

    private JdbcTemplate jdbcTemplate;

    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost/springdb");
        dataSource.setUsername("serhii");
        dataSource.setPassword("password");

        jdbcTemplate = new JdbcTemplate(dataSource);
        cartDao = new CartDao(jdbcTemplate, productRepository);
    }

    @Test
    void testAddProductToCart() throws SQLException {
        int cartId = 2;
        int productId = 3;

        cartDao.addProductToCart(cartId, productId);

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Carts WHERE cart_id = ? AND product_id = ?")
        ) {
            statement.setInt(1, cartId);
            statement.setInt(2, productId);
            ResultSet resultSet = statement.executeQuery();
            assertTrue(resultSet.next(), "Cart-product association should exist in the database");

            System.out.println("Product added to cart successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while checking cart-product association in the database");
        }
    }

    @Test
    void testRemoveProductFromCart() throws SQLException {
        int cartId = 1;
        int productId = 2;

        cartDao.removeProductFromCart(cartId, productId);

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Carts WHERE cart_id = ? AND product_id = ?")
        ) {
            statement.setInt(1, cartId);
            statement.setInt(2, productId);
            ResultSet resultSet = statement.executeQuery();
            assertFalse(resultSet.next(), "Cart-product association should not exist in the database");

            System.out.println("Product removed from cart successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while checking cart-product association in the database");
        }
    }

    @Test
    void testClearCart() throws SQLException {
        int cartId = 2;

        cartDao.clearCart(cartId);

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Carts WHERE cart_id = ?")
        ) {
            statement.setInt(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            assertFalse(resultSet.next(), "Cart should be empty in the database");

            System.out.println("Cart cleared successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception occurred while checking cart records in the database");
        }
    }

    @Test
    void testGetProductsFromCart() {
        int cartId = 1;

        List<ProductDTO> products = cartDao.getProductsFromCart(cartId);

        assertNotNull(products);
        assertEquals(1, products.size());

        System.out.println("Products in the cart:");
        products.forEach(System.out::println);
    }
}