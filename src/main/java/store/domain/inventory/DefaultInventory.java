package store.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import store.domain.product.Product;

public class DefaultInventory {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);

    }


    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
