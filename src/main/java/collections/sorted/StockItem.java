package collections.sorted;

import lombok.Getter;

public class StockItem {
    @Getter
    private final String name;
    @Getter
    private double price;
    @Getter
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price must be positive");
        this.price = price;
    }

    public void adjustStock(int quantity) {

    }


}
