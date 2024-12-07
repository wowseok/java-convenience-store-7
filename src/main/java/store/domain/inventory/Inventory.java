package store.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import store.domain.product.Product;

public class Inventory {

    private static final Inventory INSTANCE = new Inventory();
    private final DefaultInventory defaultInventory;
    private final PromotionInventory promotionInventory;

    private Inventory() {
        this.defaultInventory = new DefaultInventory();
        this.promotionInventory = new PromotionInventory();
    }


    public void addDefaultProduct(Product product) {
        defaultInventory.addProduct(product);
    }

    public void addPromotionProduct(Product product) {
        promotionInventory.addProduct(product);
    }

    public static Inventory getInstance() {
        return INSTANCE;
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(defaultInventory.getAllProducts());
        allProducts.addAll(promotionInventory.getAllProducts());
        return allProducts;
    }

}
