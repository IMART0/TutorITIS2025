package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private final List<Cell> cells; // Список ячеек склада
    private final PrintWriter writer;

    // Создание склада
    public Warehouse() {
        this.cells = new ArrayList<>();
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Склад создан\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Закрытие склада
    public void closeWarehouse() {
        writer.println("Склад закрыт\n");
        writer.close();
    }

    // Информация о складе
    public void info() {
        writer.println("Информация о складе:\n");
        for (Cell cell : cells) {
            writer.println(cell.info() + "\n\n");
        }
    }
}
