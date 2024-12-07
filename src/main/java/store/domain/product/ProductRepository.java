package store.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final ProductRepository INSTANCE = new ProductRepository();
    private final List<Product> products = new ArrayList<>();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void setUpDefaultProduct() {
        List<Product> newDefaults = new ArrayList<>();
        for (Product product : products) { // 원본 리스트 순회
            if (!product.getPromotion().equals("null") && !findDefaultProduct(product)) {
                // 새 기본 상품을 생성하고 임시 리스트에 추가
                newDefaults.add(new Product(product.getName(), product.getPrice(), 0, "null"));
            }
        }
        addNewProducts(newDefaults);
    }

    private void addNewProducts(List<Product> newDefaults) {
        // 순회가 끝난 뒤, 원본 리스트에 새 상품 추가
        for (Product newProduct : newDefaults) {
            addProduct(newProduct);
        }
    }

    public boolean findDefaultProduct(Product currentProduct) {
        for (Product product : products) {
            if (product.getName().equals(currentProduct.getName()) && product.getPromotion().equals("null")) {
                return true;
            }
        }
        return false;

    }


}
