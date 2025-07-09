package am.martirosyan;

import java.lang.reflect.Method;

public class Task1 {
    public static void main(String[] args) {
        Class<?> clazz = Person.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType().getName());
        }
    }
}
