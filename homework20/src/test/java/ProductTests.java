import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {

    @Test
    void testGetExpensiveBooks() {
        Product1 book1 = new Product1("Book", 200);
        Product1 book2 = new Product1("Book", 300);
        Product1 book3 = new Product1("Book", 400);
        Product1 phone = new Product1("Phone", 500);

        List<Product1> products = Arrays.asList(book1, book2, book3, phone);

        List<Product1> expensiveBooks = Product1.getExpensiveBooks(products);

        assertEquals(2, expensiveBooks.size());
        assertTrue(expensiveBooks.contains(book2));
        assertTrue(expensiveBooks.contains(book3));
    }

    @Test
    void testApplyDiscount() {
        Product2 product1 = new Product2("Book", 100, true);
        Product2 product2 = new Product2("Toy", 200, false);
        Product2 product3 = new Product2("Book", 150, true);
        Product2 product4 = new Product2("Toy", 120, true);

        List<Product2> products = Arrays.asList(product1, product2, product3, product4);
        List<Product2> discountedProducts = Product2.applyDiscount(products);

        assertEquals(2, discountedProducts.size());
        assertTrue(discountedProducts.contains(new Product2("Book", 90, true)));
        assertTrue(discountedProducts.contains(new Product2("Book", 135, true)));
    }

    @Test
    void testGetCheapestBook1() {
        Product3 book1 = new Product3("Book", 200, true);
        Product3 book2 = new Product3("Book", 150, true);
        Product3 book3 = new Product3("Book", 300, false);

        List<Product3> products = Arrays.asList(book1, book2, book3);

        Product3 cheapestBook = Product3.getCheapestBook(products);

        assertEquals(book2, cheapestBook);
    }

    @Test
    void testGetCheapestBook2() {
        Product3 toy1 = new Product3("Toy", 200, false);
        Product3 toy2 = new Product3("Toy", 200, false);

        List<Product3> products = Arrays.asList(toy1, toy2);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> Product3.getCheapestBook(products));

        assertEquals("Product [category: Book] not found", exception.getMessage());
    }

    @Test
    void testGetRecentProducts() {
        Product4 product1 = new Product4("Book", 100, true, LocalDate.of(2022, 1, 1));
        Product4 product2 = new Product4("Book", 200, false, LocalDate.of(2023, 3, 15));
        Product4 product3 = new Product4("Book", 300, true, LocalDate.of(2023, 5, 20));
        Product4 product4 = new Product4("Book", 150, true, LocalDate.of(2021,1,2));

        List<Product4> products = Arrays.asList(product1, product2, product3, product4);

        List<Product4> recentProducts = Product4.getRecentProducts(products);

        assertEquals(3, recentProducts.size());
        assertTrue(recentProducts.contains(product1));
        assertTrue(recentProducts.contains(product2));
        assertTrue(recentProducts.contains(product3));
    }

    @Test
    void testCalculateTotalValue() {
        Product5 product1 = new Product5("Book", 50, true, LocalDate.now());
        Product5 product2 = new Product5("Book", 100, true, LocalDate.now());
        Product5 product3 = new Product5("Book", 200, true, LocalDate.now().minusYears(1));
        Product5 product4 = new Product5("Phone", 150, false, LocalDate.now());
        Product5 product5 = new Product5("Book", 70, true, LocalDate.now());

        List<Product5> products = Arrays.asList(product1, product2, product3, product4, product5);

        double totalValue = Product5.calculateTotalValue(products);

        assertEquals(120.0, totalValue);
    }

    @Test
    void testGroupProductsByType() {
        Product6 product1 = new Product6("1", "Book", 100, true, LocalDate.of(2022, 1, 1));
        Product6 product2 = new Product6("2", "Toy", 200, false, LocalDate.of(2023, 4, 15));
        Product6 product3 = new Product6("3", "Book", 300, true, LocalDate.of(2023, 5, 20));
        Product6 product4 = new Product6("4", "Toy", 150, true, LocalDate.of(2023, 8, 1));

        List<Product6> products = Arrays.asList(product1, product2, product3, product4);

        Map<String, List<Product6>> groupedProducts = Product6.groupProductsByType(products);

        assertEquals(2, groupedProducts.size());
        assertEquals(2, groupedProducts.get("Book").size());
        assertEquals(2, groupedProducts.get("Toy").size());
        assertTrue(groupedProducts.get("Book").contains(product1));
        assertTrue(groupedProducts.get("Book").contains(product3));
        assertTrue(groupedProducts.get("Toy").contains(product2));
        assertTrue(groupedProducts.get("Toy").contains(product4));
    }
}
