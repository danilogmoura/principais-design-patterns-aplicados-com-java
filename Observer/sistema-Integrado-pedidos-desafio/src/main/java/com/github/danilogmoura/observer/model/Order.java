package com.github.danilogmoura.observer.model;

import java.util.Objects;

public class Order {

    private String description;

    private String price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
            "description='" + description + '\'' +
            ", price='" + price + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
