package am.martirosyan.task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws IOException {

        List<Student> students = fileToStudent("D:\\PetProjects\\TutorstvoITIS\\TutorITIS2025\\lab0907\\src\\main\\java\\am\\martirosyan\\task1\\students.txt");
        List<Grade> grades = fileToGrades("D:\\PetProjects\\TutorstvoITIS\\TutorITIS2025\\lab0907\\src\\main\\java\\am\\martirosyan\\task1\\grades.txt");
        List<Attendance> attendances = fileToAttendance("D:\\PetProjects\\TutorstvoITIS\\TutorITIS2025\\lab0907\\src\\main\\java\\am\\martirosyan\\task1\\attendance.txt");
        List<Course> courses = fileToCourses("D:\\PetProjects\\TutorstvoITIS\\TutorITIS2025\\lab0907\\src\\main\\java\\am\\martirosyan\\task1\\courses.txt");

        //Задание 1
        Map<String, Long> attendancesCount = new HashMap<>();

        long maxValue = 0;
        String maxValueKey = "";

        for (Course course : courses) {
            long count = attendances.stream().filter(
                    a -> a.courseId == course.id
            ).count();

            attendancesCount.put(course.name, count);

            if (count > maxValue) {
                maxValue = count;
                maxValueKey = course.name;
            }
        }

        System.out.println(attendancesCount);
        System.out.println(attendancesCount.entrySet().stream().max(
                (es, es2) -> (int) (es.getValue()- es2.getValue())
        ).get());
        System.out.println(maxValueKey);



        //Задание 2
        Map<String, List<Student>> groupStudents = students.stream().collect(
                Collectors.groupingBy(Student::getGroup)
        );

        for (String group : groupStudents.keySet()) {
            int c = 0;

            for (Student student : groupStudents.get(group)) {
                boolean flag = true;
                for (Attendance attendance : attendances) {
                    if (attendance.studentId == student.id && !attendance.attendanceMark) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    c += 1;
                }
            }

            if (c >= 2) {
                System.out.println(group);
            }
        }


        //Задание 3
//        Map<String, List<Student>> groupStudents = students.stream().collect(
//                Collectors.groupingBy(Student::getGroup)
//        );

        String courseName = "Дискра";

        for (String group : groupStudents.keySet()) {
            double avg = 0;

            for (Student student : groupStudents.get(group)) {
                for (Grade grade : grades) {
                    Course course = courses.stream().filter(c -> courseName.equals(c.name)).findFirst().get();
                    if (grade.studentId == student.id && course.id == grade.courseId) {
                        avg += grade.mark;
                    }
                }
            }

            avg = avg/groupStudents.get(group).size();

            if (avg > 4.5) {
                System.out.println(group);
            }
        }

    }

    public static String firstTask(List<Student> students,  List<Grade> grades, List<Attendance> attendances,
                                   List<Course> courses) throws IOException {
        //Задание 1
        Map<String, Long> attendancesCount = new HashMap<>();

        long maxValue = 0;
        String maxValueKey = "";

        for (Course course : courses) {
            long count = attendances.stream().filter(
                    a -> a.courseId == course.id
            ).count();

            attendancesCount.put(course.name, count);

            if (count > maxValue) {
                maxValue = count;
                maxValueKey = course.name;
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        writer.println(maxValueKey);
        writer.close();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("output"));
        os.writeObject(maxValueKey);
        os.close();


        return maxValueKey;
    }

    public static List<Student> fileToStudent(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            Student student = new Student(
                    Integer.parseInt(line.split("\\|")[0]),
                    line.split("\\|")[1],
                    Integer.parseInt(line.split("\\|")[2]),
                    line.split("\\|")[3]
            );

            students.add(student);
        }

        br.close();
        return students;
    }


    public static List<Attendance> fileToAttendance(String fileName) throws IOException {
        List<Attendance> attendances = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitString = line.split("\\|");

            Attendance attendance = new Attendance(
                    Integer.parseInt(splitString[0]),
                    Integer.parseInt(splitString[1]),
                    splitString[2],
                    Boolean.parseBoolean(splitString[3]),
                    splitString[4]
                    );

            attendances.add(attendance);
        }

        br.close();
        return attendances;
    }


    public static List<Grade> fileToGrades(String fileName) throws IOException {
        List<Grade> grades = new ArrayList<>();


        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitString = line.split("\\|");

            Grade grade = new Grade(
                    Integer.parseInt(splitString[0]),
                    Integer.parseInt(splitString[1]),
                    Double.parseDouble(splitString[2])
            );

            grades.add(grade);
        }

        br.close();
        return grades;
    }

    public static List<Course> fileToCourses(String fileName) throws IOException {
        List<Course> courses = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitString = line.split("\\|");

            Course course = new Course(
                    Integer.parseInt(splitString[0]),
                    splitString[1],
                    Integer.parseInt(splitString[2])
            );

            courses.add(course);
        }
        br.close();
        return courses;
    }
}
