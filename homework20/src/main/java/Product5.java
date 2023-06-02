import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public record Product5(String type, double price, boolean discount, LocalDate createDate) {
    public static double calculateTotalValue(List<Product5> products) {
        int currentYear = Year.now().getValue();
        return products.stream()
                .filter(product -> product.type().equals("Book"))
                .filter(product -> product.price() <= 75)
                .filter(product -> product.createDate().getYear() == currentYear)
                .mapToDouble(Product5::price)
                .sum();
    }
}