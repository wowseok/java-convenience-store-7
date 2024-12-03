package store.domain.product;

import store.domain.product.dto.ProductDTO;
import store.domain.product.dto.ProductDTORepository;

public class ProductFactory {

    public static void createProductDTO(String name, String price, String quantity, String promotion) {
        ProductDTORepository.addProductDTO(new ProductDTO(name, price, quantity, promotion));
    }
}
