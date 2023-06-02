import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Product6(String id, String type, double price, boolean discount, LocalDate createDate) {
    public static Map<String, List<Product6>> groupProductsByType(List<Product6> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product6::type));
    }
}