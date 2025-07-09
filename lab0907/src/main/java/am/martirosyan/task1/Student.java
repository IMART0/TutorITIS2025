package am.martirosyan.task1;

public class Student {

    public Student(int id, String name, int age, String group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public int id;
    public String name;
    public int age;
    public String group;


    public String getGroup() {
        return group;
    }
}
