package am.martirosyan;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task2 {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Person.class;

        Method method = clazz.getDeclaredMethod(
            "setAge",
                int.class
        );

        Person person = (Person) clazz.newInstance();

        method.setAccessible(true); // позволяет вызвать приватный метод

        method.invoke(person, 30);

        System.out.println("Person's age: " + person.getAge());

    }
}
