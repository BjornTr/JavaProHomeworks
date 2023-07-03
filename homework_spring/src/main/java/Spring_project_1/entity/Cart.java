package Spring_project_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private List<Product> items = new LinkedList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void deleteProduct(int id) {
        items.removeIf(product -> product.getId() == id);
    }
}