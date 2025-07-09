package com.example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final String name; // Имя покупателя
    private final List<Product> purchasedProducts; // Список купленных товаров

    private final PrintWriter writer;

    public Buyer(String name) {
        this.name = name;
        this.purchasedProducts = new ArrayList<>();

        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Покупатель " + name + " создан\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Покупка товара
    public void buyProduct(Product product, Store store) {
        purchasedProducts.add(product);
        store.sellProduct(product);
        writer.println(name + " купил " + product.getName());
    }

    // Возврат товара
    public void returnProduct(Product product, Store store) {
        if (purchasedProducts.contains(product)) {
            purchasedProducts.remove(product);
            store.addProduct(product);
            writer.println(name + " вернул " + product.getName());
        }
    }
}
