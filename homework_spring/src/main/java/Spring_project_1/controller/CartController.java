package Spring_project_1.controller;

import Spring_project_1.dto.ProductDTO;
import Spring_project_1.entity.Cart;
import Spring_project_1.entity.Product;
import Spring_project_1.mapper.ProductMapper;
import Spring_project_1.repository.ProductRepository;
import Spring_project_1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ProductRepository productRepository;
    private final CartService cartService;
    private final ProductMapper productMapper;


    @Autowired
    public CartController(ProductRepository productRepository, CartService cartService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.cartService = cartService;
        this.productMapper = productMapper;
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public List<ProductDTO> getCartItems() {
        Cart cart = cartService.getCart();
        List<Product> items = cart.getItems();
        return items.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public void addProductToCart(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        cartService.addProductToCart(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductFromCart(@PathVariable int id) {
        cartService.removeProductFromCart(id);
    }
}