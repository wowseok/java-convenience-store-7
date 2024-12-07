package store.domain.product;

public class ProductFactory {


    public static void createProductDTO(String name, int price, int quantity, String promotion) {
        ProductRepository repository = ProductRepository.getInstance();
        repository.addProduct(new Product(name, price, quantity, promotion));
    }
}
