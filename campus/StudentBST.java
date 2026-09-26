package campus;

public class StudentBST {

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

        int comparison =
                student.getStudentId()
                        .compareTo(node.student.getStudentId());

        if (comparison < 0) {
            node.left = insertNode(node.left, student);
        } else if (comparison > 0) {
            node.right = insertNode(node.right, student);
        }

        return node;
    }

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

        int comparison =
                studentId.compareTo(node.student.getStudentId());

        if (comparison == 0) {
            return node;
        } else if (comparison < 0) {
            return searchNode(node.left, studentId);
        } else {
            return searchNode(node.right, studentId);
        }
    }

    public void deleteStudent(String studentId) {

        if (searchStudent(studentId) == null) {
            System.out.println("Student not found in BST.");
            return;
        }

        root = deleteNode(root, studentId);

        System.out.println(
                "BST deletion successful for Student ID: "
                        + studentId
        );
    }

    private Node deleteNode(Node node, String studentId) {

        if (node == null) {
            return null;
        }

        int comparison =
                studentId.compareTo(node.student.getStudentId());

        if (comparison < 0) {

            node.left =
                    deleteNode(node.left, studentId);

        } else if (comparison > 0) {

            node.right =
                    deleteNode(node.right, studentId);

        } else {

            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node successor = findMinimum(node.right);

            node.student = successor.student;

            node.right =
                    deleteNode(
                            node.right,
                            successor.student.getStudentId()
                    );
        }

        return node;
    }

    private Node findMinimum(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

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

