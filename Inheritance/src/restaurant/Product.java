package restaurant;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    // constructor
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
