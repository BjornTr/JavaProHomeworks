import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public record Product3(String category, double price, boolean discount) {
    public static Product3 getCheapestBook(List<Product3> products) {
        Optional<Product3> cheapestBook = products.stream()
                .filter(product -> product.category().equals("Book"))
                .min(Comparator.comparingDouble(Product3::price));

        return cheapestBook.orElseThrow(() -> new RuntimeException("Product [category: Book] not found"));
    }
}