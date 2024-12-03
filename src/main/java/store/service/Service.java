package store.service;

import java.util.List;
import java.util.Map;
import store.domain.product.ProductFactory;

public class Service {

    public void setUp(String input) {

    }

    public void setUpFile(List<Map<String, String>> products) {
        for (Map<String, String> product : products) {
            String name = product.get("name");
            String price = product.get("price");
            String quantity = product.get("quantity");
            String promotion = product.get("promotion");
            ProductFactory.createProductDTO(name, price, quantity, promotion);
        }
    }

}
