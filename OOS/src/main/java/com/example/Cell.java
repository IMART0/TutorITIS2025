package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Product> products; // Список продуктов в ячейке
    private Employer employer; // Работник, ответственный за ячейку

    private final PrintWriter writer;

    // Создание ячейки
    public Cell() {
        this.products = new ArrayList<>();
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Ячейка создана\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Добавление продукта в ячейку
    public void addProduct(Product product) {
        products.add(product);
        writer.println(product.getName() + " добавлен в ячейку\n");
    }


    // Удаление продукта из ячейки
    public void removeProduct(Product product) {
        products.remove(product);
        writer.println(product.getName() + " удален из ячейки\n");
    }

    // Перемещение товаров
    public void replaceProduct(Product product, Cell newCell) {
        if (products.contains(product)) {
            products.remove(product);
            newCell.addProduct(product);
            writer.println(product.getName() + " перемещен в другую ячейку\n");
        }
    }

    //Найм сотрудника
    public void addEmployer(Employer employer) {
        this.employer = employer;
        writer.println("Работник " + employer.getName() + " назначен на ячейку\n");
    }

    //Смена ответственного лица
    public void changeEmployer(Employer newEmployer) {
        writer.println("Работник " + this.employer.getName() + " заменен на " + newEmployer.getName() + "");
        this.employer = newEmployer;
    }

    //Увольнение работника
    public void removeEmployer() {
        writer.println("Работник " + this.employer.getName() + " уволен\n");
        this.employer = null;
    }

    //Закрытие ячейки
    public void closeCell() {
        writer.println("Ячейка закрыта\n");
        writer.close();
    }

    //Информация о ячейке
    public String info() {
        StringBuilder info = new StringBuilder("Информация о ячейке:\n");
        info.append("Продукты в ячейке:\n");
        for (Product product : products) {
            info.append(product.getName()).append("\n");
        }
        if (employer != null) {
            info.append("Ответственный работник: \n").append(employer.getName()).append("\n");
        } else {
            info.append("Нет ответственного работника\n");
        }
        return info.toString();
    }
}
