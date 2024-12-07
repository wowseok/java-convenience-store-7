package store.service;

import java.util.List;
import java.util.Map;
import store.domain.inventory.Inventory;
import store.domain.order.ItemOrder;
import store.domain.product.ProductFactory;
import store.domain.product.ProductFormatter;
import store.domain.product.ProductRepository;
import store.domain.promotion.PromotionFactory;
import store.util.InputParser;

public class Service {
    private final ProductRepository productRepository;
    private final Inventory inventory;

    public void setUpPurchaseProducts(String input) {
        List<ItemOrder> ItemOrders = InputParser.parseInput(input);
        for (ItemOrder order : ItemOrders) {
            inventory.removeProductByName(order.getName(), order.getQuantity());
        }
    }

    public Service() {
        this.productRepository = ProductRepository.getInstance();
        this.inventory = Inventory.getInstance();
    }

    public void setUpProductFile(List<Map<String, String>> products) {
        for (Map<String, String> product : products) {
            String name = product.get("name");
            int price = Integer.parseInt(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));
            String promotion = product.get("promotion");
            ProductFactory.createProductDTO(name, price, quantity, promotion);
        }
        productRepository.setUpDefaultProduct();
    }

    public void setUpPromotionFile(List<Map<String, String>> promotions) {
        for (Map<String, String> promotion : promotions) {
            String name = promotion.get("name");
            int buy = Integer.parseInt(promotion.get("buy"));
            int get = Integer.parseInt(promotion.get("get"));
            String startDate = promotion.get("start_date");
            String endDate = promotion.get("end_date");
            PromotionFactory.createPromotion(name, buy, get, startDate, endDate);
        }
    }

    public List<String> getFormattedProducts() {
        // ProductFormatter를 사용해 포맷된 제품 정보를 반환
        return ProductFormatter.formatProducts(inventory.getAllProducts());
    }


}
