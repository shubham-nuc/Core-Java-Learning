package java8.mockdata.model;

import java.math.BigDecimal;

public class Fruit {
    private final String name;
    private final int qty;
    private final BigDecimal price;

    public Fruit(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public int qty() {
        return qty;
    }

    public BigDecimal price() {
        return price;
    }
}
