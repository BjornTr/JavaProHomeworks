import java.util.List;

public record Product1(String type, double price) {
    public static List<Product1> getExpensiveBooks(List<Product1> products) {
        return products.stream()
                .filter(product -> product.type().equals("Book") && product.price() > 250)
                .toList();
    }
}