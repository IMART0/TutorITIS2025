package am.martirosyan;

public class Person {
    private String name;

    @Hidden
    public int age;

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
