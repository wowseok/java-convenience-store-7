package store.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import store.domain.product.Product;
import store.domain.promotion.Promotion;

public class Inventory {

    private static final Inventory INSTANCE = new Inventory();
    private final DefaultInventory defaultInventory;
    private final PromotionInventory promotionInventory;

    private Inventory() {
        this.defaultInventory = new DefaultInventory();
        this.promotionInventory = new PromotionInventory();
    }


    public void addDefaultProduct(Product product) {
        defaultInventory.add(product);
    }

    public void addPromotionProduct(Product product) {
        promotionInventory.add(product);
    }

    public void removeProductByName(String productName, int quantity) {

        removePromotionProduct(productName, quantity);
        removeDefaultProduct(productName, quantity);
    }

    private void removeDefaultProduct(String productName, int quantity) {
        if (promotionInventory.findByName(productName) == null) {
            if (defaultInventory.findByName(productName) != null) {
                Product product = defaultInventory.findByName(productName);
                if (product.getQuantity() >= quantity) {
                    defaultInventory.remove(product, quantity);
                }
            }

            if (defaultInventory.findByName(productName) == null) {
                throw new IllegalArgumentException("존재하지 않는 상품입니다");
            }
        }
    }

    private void removePromotionProduct(String productName, int quantity) {
        if (promotionInventory.findByName(productName) != null) {
            Product product = promotionInventory.findByName(productName);
            Promotion promotion = Promotion.findByName(product.getPromotion());
            if (promotion.isValid()) {
                if (product.getQuantity() >= quantity) {
                    promotionInventory.remove(product, quantity);
                }
            }
        }
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
