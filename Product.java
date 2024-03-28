package assignment;

import java.util.Objects;

public class Product {
    private int key;
    private String name;
    private double price;


    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }

    public Product(int key, String name, double price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return key == product.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
