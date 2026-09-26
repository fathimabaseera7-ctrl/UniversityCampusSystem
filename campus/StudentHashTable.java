package campus;

public class StudentHashTable {

    private static final int TABLE_SIZE = 10;

    private Student[] table;

    public StudentHashTable() {
        table = new Student[TABLE_SIZE];
    }

    // ==========================================
    // HASH FUNCTION
    // ==========================================

    private int hashFunction(String studentId) {

        return Math.abs(studentId.hashCode()) % TABLE_SIZE;
    }

    // ==========================================
    // ADD STUDENT
    // ==========================================

    public void addStudent(Student student) {

        if (student == null) {
            System.out.println("Invalid student.");
            return;
        }

        int index =
                hashFunction(student.getStudentId());

        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(student.getStudentId())) {

                System.out.println(
                        "Student ID already exists in Hash Table."
                );

                return;
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == originalIndex) {

                System.out.println(
                        "Hash Table is full."
                );

                return;
            }
        }

        table[index] = student;

        System.out.println(
                "Student added to Hash Table at index "
                        + index
        );
    }

    // ==========================================
    // SEARCH STUDENT
    // ==========================================

    public Student searchStudent(String studentId) {

        if (studentId == null) {
            return null;
        }

        int index = hashFunction(studentId);

        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(studentId)) {

                return table[index];
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == originalIndex) {
                break;
            }
        }

        return null;
    }

    // ==========================================
    // DELETE STUDENT
    // ==========================================

    public void deleteStudent(String studentId) {

        if (studentId == null) {
            System.out.println("Invalid Student ID.");
            return;
        }

        int index = hashFunction(studentId);

        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(studentId)) {

                table[index] = null;

                System.out.println(
                        "Student deleted from Hash Table: "
                                + studentId
                );

                return;
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == originalIndex) {
                break;
            }
        }

        System.out.println(
                "Student not found in Hash Table."
        );
    }

    // ==========================================
    // DISPLAY HASH TABLE
    // ==========================================

    public void displayHashTable() {

        System.out.println("================================");
        System.out.println("       STUDENT HASH TABLE");
        System.out.println("================================");

        for (int i = 0; i < TABLE_SIZE; i++) {

            System.out.print(
                    "Index " + i + " : "
            );

            if (table[i] == null) {

                System.out.println("Empty");

            } else {

                System.out.println(
                        table[i].getStudentId()
                                + " - "
                                + table[i].getName()
                );
            }
        }

        System.out.println("--------------------------------");
    }
}