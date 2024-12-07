package store.domain.product;

public class Product {
    private final String name;
    private final int price;
    private int quantity;
    private final String promotion;

    public Product(String name, int price, int quantity, String promotion) {
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

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity = quantity - amount;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%d, quantity=%d, promotion='%s'}",
                name, price, quantity, promotion);
    }
}
