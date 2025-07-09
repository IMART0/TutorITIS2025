package am.martirosyan.task1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestClass {
    @Test
    public void testGetMostAttendedCourse() {
        List<Student> students = List.of(
                new Student(1, "Тарас", 19, "11-777")
        );

        List<Grade> grades = List.of();

        List<Attendance> attendances = List.of(
                new Attendance(1, 1, "123", true, "123"),
                new Attendance(1, 1, "123", true, "123"),
                new Attendance(1, 2, "123", true, "123")
        );

        List<Course> courses = List.of(
                new Course(1, "Дискра", 108),
                new Course(2, "Матан", 123)
        );

        assertEquals(
                "Дискра",
                Task1.firstTask(students, grades, attendances, courses)
        );
    }
}
