package Spring_project_1.repository;

import Spring_project_1.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDao(JdbcTemplate jdbcTemplate, ProductRepository productRepository) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProductToCart(int cartId, int productId) {
        String sql = "INSERT INTO Carts (cart_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public void removeProductFromCart(int cartId, int productId) {
        String sql = "DELETE FROM Carts WHERE cart_id = ? AND product_id = ?";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public void clearCart(int cartId) {
        String sql = "DELETE FROM Carts WHERE cart_id = ?";
        jdbcTemplate.update(sql, cartId);
    }

    public List<ProductDTO> getProductsFromCart(int cartId) {
        String sql = "SELECT p.id, p.name, p.price FROM Carts c " +
                "JOIN Products p ON c.product_id = p.id " +
                "WHERE c.cart_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            return new ProductDTO(id, name, price);
        }, cartId);
    }
}