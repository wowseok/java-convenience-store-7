package store.domain.order;

public class ItemOrder {
    private final String name;
    private final int quantity;

    public ItemOrder(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ItemOrder createOrder(String name, String quantity) {
        int parsedQuantity = Integer.parseInt(quantity);
        return new ItemOrder(name, parsedQuantity);
    }

    @Override
    public String toString() {
        return "상품명: " + name + ", 수량: " + quantity;
    }
}