package campus;

@SuppressWarnings("java:S106")
public class StudentBST {

    // ==========================================
    // NODE CLASS
    // ==========================================
    private class Node {

        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // ==========================================
    // INSERT STUDENT
    // ==========================================
    public void insertStudent(Student student) {

        if (student == null) {
            System.out.println("Invalid student.");
            return;
        }

        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Student ID already exists in BST.");
            return;
        }

        root = insertNode(root, student);

        System.out.println(
                "Student inserted into BST: "
                + student.getStudentId()
        );
    }

    private Node insertNode(Node node, Student student) {

        if (node == null) {
            return new Node(student);
        }

        int comparison = student.getStudentId()
                .compareTo(node.student.getStudentId());

        if (comparison < 0) {

            node.left = insertNode(node.left, student);

        } else if (comparison > 0) {

            node.right = insertNode(node.right, student);
        }

        return node;
    }

    // ==========================================
    // SEARCH STUDENT
    // ==========================================
    public Student searchStudent(String studentId) {

        Node result = searchNode(root, studentId);

        if (result == null) {
            return null;
        }

        return result.student;
    }

    private Node searchNode(Node node, String studentId) {

        if (node == null || studentId == null) {
            return null;
        }

        int comparison = studentId
                .compareTo(node.student.getStudentId());

        if (comparison == 0) {
            return node;

        } else if (comparison < 0) {
            return searchNode(node.left, studentId);

        } else {
            return searchNode(node.right, studentId);
        }
    }

    // ==========================================
    // DISPLAY BST - INORDER
    // ==========================================
    public void displayStudents() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("================================");
        System.out.println("       STUDENTS IN BST");
        System.out.println("================================");

        inorder(root);

        System.out.println("--------------------------------");
    }

    private void inorder(Node node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        node.student.displayStudent();

        System.out.println("--------------------------------");

        inorder(node.right);
    }
}

