package store.domain.product.dto;

public class ProductDTO {
    private final String name;
    private final int price;
    private final int quantity;
    private final String promotion;

    public ProductDTO(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getPromotion() {
        return promotion;
    }


    @Override
    public String toString() {
        return String.format("ProductDTO{name='%s', price=%d, quantity=%d, promotion='%s'}",
                name, price, quantity, promotion);
    }
}
