package am.martirosyan;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private transient String password;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String toString() {
        return name + " (" + age + " лет)";
    }
}
