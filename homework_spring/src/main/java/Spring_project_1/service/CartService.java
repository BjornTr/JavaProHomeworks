package Spring_project_1.service;

import Spring_project_1.entity.Cart;
import Spring_project_1.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CartService {

    private final Cart cart;

    public CartService() {
        cart = new Cart();
    }

    public void removeProductFromCart(int id) {
        cart.deleteProduct(id);
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public Cart getCart() {
        return cart;
    }
}
