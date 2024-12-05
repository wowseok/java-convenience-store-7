package store.domain.product;

import store.domain.product.dto.ProductDTO;
import store.domain.product.dto.ProductDTORepository;

public class ProductFactory {


    public static void createProductDTO(String name, int price, int quantity, String promotion) {
        ProductDTORepository repository = ProductDTORepository.getInstance();
        repository.addProductDTO(new ProductDTO(name, price, quantity, promotion));
    }
}
