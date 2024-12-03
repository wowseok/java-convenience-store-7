package store.domain.product.dto;

public class ProductDTO {
    private final String name;
    private final int price;
    private final int quantity;
    private final String promotion;

    public ProductDTO(String name, String price, String quantity, String promotion) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.quantity = Integer.parseInt(quantity);
        this.promotion = promotion;
    }


    @Override
    public String toString() {
        return String.format("ProductDTO{name='%s', price=%d, quantity=%d, promotion='%s'}",
                name, price, quantity, promotion);
    }
}
