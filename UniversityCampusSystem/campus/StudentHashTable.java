package campus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentHashTable {

    private static final int TABLE_SIZE = 10;
    private static final Logger LOGGER = Logger.getLogger(StudentHashTable.class.getName());
    private Student[] table;

    public StudentHashTable() {
        table = new Student[TABLE_SIZE];
    }

    private int hashFunction(String studentId) {
        return Math.floorMod(studentId.hashCode(), TABLE_SIZE);
    }

    public void addStudent(Student student) {
        if (student == null) {
            LOGGER.warning("Invalid student.");
            return;
        }

        int index = hashFunction(student.getStudentId());
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].getStudentId().equals(student.getStudentId())) {
                LOGGER.info("Student ID already exists in Hash Table.");
                return;
            }

            index = (index + 1) % TABLE_SIZE;
            if (index == originalIndex) {
                LOGGER.warning("Hash Table is full.");
                return;
            }
        }

        table[index] = student;
        LOGGER.log(Level.INFO, "Student added to Hash Table at index {0}", index);
    }

    public Student searchStudent(String studentId) {
        if (studentId == null) {
            return null;
        }

        int index = hashFunction(studentId);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].getStudentId().equals(studentId)) {
                return table[index];
            }

            index = (index + 1) % TABLE_SIZE;
            if (index == originalIndex) {
                break;
            }
        }

        return null;
    }

    public void displayHashTable() {
        LOGGER.info("================================");
        LOGGER.info("       STUDENT HASH TABLE");
        LOGGER.info("================================");

        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i] == null) {
                LOGGER.log(Level.INFO, "Index {0} : Empty", i);
            } else {
                LOGGER.log(
                        Level.INFO,
                        "Index {0} : {1} - {2}",
                        new Object[] {i, table[i].getStudentId(), table[i].getName()}
                );
            }
        }

        LOGGER.info("--------------------------------");
    }
}
