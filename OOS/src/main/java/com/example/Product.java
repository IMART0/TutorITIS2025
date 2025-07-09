package com.example;

public class Product {

    private final String name; // Название товара
    private final double price; // Цена товара

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
