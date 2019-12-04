package kroger.odilonj.delayed_rest_product.entities;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public final class Product {

    private String name;
    private Double price;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
