package store.domain.product.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTORepository {
    private static final ProductDTORepository INSTANCE = new ProductDTORepository();
    private final List<ProductDTO> products = new ArrayList<>();

    private ProductDTORepository() {
    }

    public static ProductDTORepository getInstance() {
        return INSTANCE;
    }

    public void addProductDTO(ProductDTO productDTO) {
        products.add(productDTO);

    }

    public void setUpDefaultProduct() {
        List<ProductDTO> newDefaults = new ArrayList<>();
        for (ProductDTO product : products) { // 원본 리스트 순회
            if (!product.getPromotion().equals("null") && !findDefaultProduct(product)) {
                // 새 기본 상품을 생성하고 임시 리스트에 추가
                newDefaults.add(new ProductDTO(product.getName(), product.getPrice(), 0, "null"));
            }
        }
        addNewProducts(newDefaults);
        for (ProductDTO product : products) {
            System.out.println(product);
        }
    }

    private void addNewProducts(List<ProductDTO> newDefaults) {
        // 순회가 끝난 뒤, 원본 리스트에 새 상품 추가
        for (ProductDTO newProduct : newDefaults) {
            addProductDTO(newProduct);
        }
    }

    public boolean findDefaultProduct(ProductDTO currentProduct) {
        for (ProductDTO product : products) {
            if (product.getName().equals(currentProduct.getName()) && product.getPromotion().equals("null")) {
                return true;
            }
        }
        return false;

    }


}
