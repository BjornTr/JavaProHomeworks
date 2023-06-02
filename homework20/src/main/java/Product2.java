import java.util.List;

public record Product2(String type, double price, boolean discount) {
    public static List<Product2> applyDiscount(List<Product2> products) {
        return products.stream()
                .filter(product -> product.type().equals("Book") && product.discount)
                .map(product -> new Product2(product.type(), product.price * 0.9, true))
                .toList();
    }
}
