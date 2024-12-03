package store.domain.product.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTORepository {
    private static final List<ProductDTO> products = new ArrayList<>();

    private ProductDTORepository() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void addProductDTO(ProductDTO productDTO) {
        products.add(productDTO);

    }

    public static List<ProductDTO> getProducts() {
        return new ArrayList<>(products);
    }


}
