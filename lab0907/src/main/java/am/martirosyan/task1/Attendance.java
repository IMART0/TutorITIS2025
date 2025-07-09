package am.martirosyan.task1;

public class Attendance {

    public Attendance(int studentId, int courseId, String date, boolean attendanceMark, String time) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.attendanceMark = attendanceMark;
        this.time = time;
    }

    int studentId;
    int courseId;
    String date;
    boolean attendanceMark;
    String time;
}
