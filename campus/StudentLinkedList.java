package campus;

public class StudentLinkedList {

    private Node head;

    private class Node {

        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public void addStudent(Student student) {

        if (student == null) {
            System.out.println("Invalid student.");
            return;
        }

        if (searchStudent(student.getStudentId()) != null) {
            System.out.println(
                    "Student ID already exists: "
                            + student.getStudentId()
            );
            return;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            System.out.println("Student added successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println("Student added successfully.");
    }

    public Student searchStudent(String studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public void updateStudent(
            String studentId,
            String name,
            String programme,
            double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(String studentId) {

        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        if (head.student.getStudentId().equals(studentId)) {

            head = head.next;

            System.out.println("Student deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student
                    .getStudentId()
                    .equals(studentId)) {

                current.next = current.next.next;

                System.out.println(
                        "Student deleted successfully."
                );

                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        System.out.println("================================");
        System.out.println("       STUDENT RECORDS");
        System.out.println("================================");

        while (current != null) {

            current.student.displayStudent();

            System.out.println("--------------------------------");

            current = current.next;
        }
    }
}