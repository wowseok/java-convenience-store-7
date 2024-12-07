package store.domain.inventory;

import store.domain.product.Product;
import store.domain.product.ProductRepository;

public class InventoryFactory {

    public static void createInventory() {
        Inventory inventory = Inventory.getInstance();
        ProductRepository repository = ProductRepository.getInstance();
        setInventory(repository, inventory);
    }

    private static void setInventory(ProductRepository repository, Inventory inventory) {
        for (Product product : repository.getProducts()) {
            if (isPromotion(product)) {
                inventory.addPromotionProduct(product);
            }
            if (!isPromotion(product)) {
                inventory.addDefaultProduct(product);
            }
        }
    }


    public static boolean isPromotion(Product product) {
        if (product.getPromotion().equals("null")) {
            return false;
        }
        return true;
    }
}

