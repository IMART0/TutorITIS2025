package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products; // Список товаров
    private double income = 0; // Доход магазина

    private final PrintWriter writer;

    // Создание магазина
    public Store() {
        this.products = new ArrayList<>();
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Магазин создан\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Закупка товара
    public void purchaseProduct(Product product, Cell cell) {
        products.add(product);
        cell.removeProduct(product);
        writer.println(product.getName() + " закуплен\n");
    }

    // Продажа товара
    public void sellProduct(Product product) {
        products.remove(product);
        writer.println(product.getName() + " продан\n");
        income += product.getPrice();
    }

    // Добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
        writer.println(product.getName() + " добавлен в магазин\n");
    }

    // Закрытие магазина
    public void closeStore() {
        writer.println("Магазин закрыт\n");
        writer.close();
    }

    // Информация о магазине
    public void info() {
        writer.println("Информация о магазине:\n");
        for (Product product : products) {
            writer.println(product.getName());
        }
        writer.println("Доход магазина: " + income);
        writer.println();
    }

    // Доход магазина
    public double getIncome() {
        return income;
    }

    public List<Product> getProducts() {
        return products;
    }
}
