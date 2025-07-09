package am.martirosyan;

import java.util.List;

public class User<T> {
    Object value;

    void printString(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    void printInteger(List<Integer> list) {
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    void instanceOfExample() {
        if (value instanceof String) {
            System.out.println("Value is a String: " + value);
        } else if (value instanceof Integer) {
            System.out.println("Value is an Integer: " + value);
        } else {
            System.out.println("Value is of unknown type: " + value);
        }
    }

}