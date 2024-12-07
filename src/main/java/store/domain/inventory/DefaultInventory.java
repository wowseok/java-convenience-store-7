package store.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import store.domain.product.Product;

public class DefaultInventory {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);

    }

    public void remove(Product product, int quantity) {
        product.reduceQuantity(quantity);
    }

    public Product findByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null; // 제품을 찾지 못한 경우
    }


    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
