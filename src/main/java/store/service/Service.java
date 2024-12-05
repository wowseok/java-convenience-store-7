package store.service;

import java.util.List;
import java.util.Map;
import store.domain.product.ProductFactory;
import store.domain.product.ProductFormatter;
import store.domain.product.dto.ProductDTORepository;

public class Service {
    private final ProductDTORepository dtoRepository;

    public void setUp(String input) {

    }

    public Service() {
        this.dtoRepository = ProductDTORepository.getInstance();
    }

    public void setUpFile(List<Map<String, String>> products) {
        for (Map<String, String> product : products) {
            String name = product.get("name");
            int price = Integer.parseInt(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));
            String promotion = product.get("promotion");
            ProductFactory.createProductDTO(name, price, quantity, promotion);
        }
        dtoRepository.setUpDefaultProduct();
    }

    public List<String> getFormattedProducts() {
        // ProductFormatter를 사용해 포맷된 제품 정보를 반환
        return ProductFormatter.formatProducts(dtoRepository.getProducts());
    }


}
