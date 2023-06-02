import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public record Product4(String type, double price, boolean discount, LocalDate createDate) {
    public static List<Product4> getRecentProducts(List<Product4> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product4::createDate).reversed())
                .limit(3)
                .toList();
    }
}