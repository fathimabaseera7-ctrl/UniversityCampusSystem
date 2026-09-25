package campus;

import java.util.logging.Logger;

public class Student {

    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    private String studentId;
    private String name;
    private String programme;
    private double marks;

    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {
        LOGGER.info(() -> "Student ID : " + studentId);
        LOGGER.info(() -> "Name       : " + name);
        LOGGER.info(() -> "Programme  : " + programme);
        LOGGER.info(() -> "Marks      : " + marks);
    }
}
