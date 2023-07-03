package Spring_project_1;

import Spring_project_1.entity.Cart;
import Spring_project_1.entity.Product;
import Spring_project_1.repository.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class CartConsoleApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("Spring_project_1");
            context.register(ProductRepository.class);
            context.register(Cart.class);
            context.refresh();

            ProductRepository productRepository = context.getBean(ProductRepository.class);
            Cart cart = context.getBean(Cart.class);

            while (true) {
                displayMenu();

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> displayAllProducts(productRepository);
                    case 2 -> addProductToCart(productRepository, cart);
                    case 3 -> removeProductFromCart(cart);
                    case 4 -> displayCartItems(cart);
                    case 5 -> {
                        System.out.println("Exiting the program...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Cart Menu =========");
        System.out.println("1. Display all products");
        System.out.println("2. Add product to cart");
        System.out.println("3. Remove product from cart");
        System.out.println("4. Display cart items");
        System.out.println("5. Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice: ");
    }

    private static void displayAllProducts(ProductRepository productRepository) {
        System.out.println("All products:");
        List<Product> products = productRepository.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }
    }

    private static void addProductToCart(ProductRepository productRepository, Cart cart) {
        displayAllProducts(productRepository);

        System.out.print("Enter the ID of the product to add: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = productRepository.getProductById(productId);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeProductFromCart(Cart cart) {
        displayCartItems(cart);

        System.out.print("Enter the ID of the product to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        cart.deleteProduct(productId);
        System.out.println("Product removed from cart.");
    }

    private static void displayCartItems(Cart cart) {
        List<Product> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart items:");
            for (Product product : items) {
                System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
            }
        }
    }
}