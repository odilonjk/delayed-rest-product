package kroger.odilonj.delayed_rest_product.services;

import kroger.odilonj.delayed_rest_product.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ProductService {

    public Product getProduct(String name) {
        double price = getPrice();
        return new Product(name, price);
    }

    private double getPrice() {
        double priceNotFormated = Math.random() * (99.99 - 0.01) + 0.01;
        return Math.round(priceNotFormated*100)/100.0;
    }

    public Product getProductWithDelay(String name, int time) {
        sleep(time);
        return getProduct(name);
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
