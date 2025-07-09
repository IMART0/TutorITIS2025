package am.martirosyan;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Task3 {
    public static void main(String[] args) {
        Class<?> clazz = Person.class;

        for (Field field : clazz.getDeclaredFields()) {

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Hidden.class) {
                    System.out.println("Field " + field.getName() + " is hidden and will not be displayed.");
                }
            }

            System.out.println("Field Name: " + field.getName() + ", Type: " + field.getType().getName());

        }
    }
}
