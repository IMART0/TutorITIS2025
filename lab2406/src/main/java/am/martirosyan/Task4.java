package am.martirosyan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Task4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Person.class;

        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

        Person person = (Person) constructor.newInstance("John Doe", 25);

        System.out.println("Person's Name: " + person.getName());
        System.out.println("Person's Age: " + person.getAge());


        User<String> user = new User<>();

        user.instanceOfExample();
    }
}
