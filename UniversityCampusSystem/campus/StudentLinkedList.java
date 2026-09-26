package campus;

@SuppressWarnings("java:S106")
public class StudentLinkedList {

    // First node of the linked list
    private Node head;

    // Node class
    private class Node {

        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // ==========================================
    // ADD STUDENT
    // ==========================================
    public void addStudent(Student student) {

        // Check duplicate Student ID
        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Student ID already exists: "
                    + student.getStudentId());
            return;
        }

        Node newNode = new Node(student);

        // If list is empty
        if (head == null) {
            head = newNode;
            System.out.println("Student added successfully.");
            return;
        }

        // Go to the last node
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        // Add new node at the end
        current.next = newNode;

        System.out.println("Student added successfully.");
    }

    // ==========================================
    // SEARCH STUDENT
    // ==========================================
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

    // ==========================================
    // UPDATE STUDENT
    // ==========================================
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

    // ==========================================
    // DELETE STUDENT
    // ==========================================
    public void deleteStudent(String studentId) {

        // List is empty
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }

        // Delete first node
        if (head.student.getStudentId().equals(studentId)) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Node current = head;

        // Find the node before the student
        while (current.next != null) {

            if (current.next.student.getStudentId().equals(studentId)) {

                current.next = current.next.next;

                System.out.println("Student deleted successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    // ==========================================
    // DISPLAY ALL STUDENTS
    // ==========================================
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
