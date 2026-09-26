package campus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();
        StudentBST studentBST = new StudentBST();
        StudentHashTable hashTable = new StudentHashTable();
        CampusGraph campusGraph = new CampusGraph();

        // ==========================================
        // DEFAULT STUDENT RECORDS
        // ==========================================

        Student student1 = new Student(
                "23DA2-0872",
                "MA Aathif ahamed",
                "BAIT",
                80
        );

        Student student2 = new Student(
                "23DA2-0662",
                "MF FASEERA",
                "BAIT",
                85
        );

        Student student3 = new Student(
                "23DA2-0946",
                "RFF NUSHA",
                "BAIT",
                90
        );

        Student student4 = new Student(
                "23DA2-1017",
                "AF NASRIYA",
                "BAIT",
                95
        );

        // Add to Linked List
        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);
        studentList.addStudent(student4);

        // Add to BST
        studentBST.insertStudent(student1);
        studentBST.insertStudent(student2);
        studentBST.insertStudent(student3);
        studentBST.insertStudent(student4);

        // Add to Hash Table
        hashTable.addStudent(student1);
        hashTable.addStudent(student2);
        hashTable.addStudent(student3);
        hashTable.addStudent(student4);

        System.out.println();
        System.out.println("4 student records loaded successfully.");
        System.out.println();

        int choice = 0;

         do {

            // ==========================================
            // MAIN MENU
            // ==========================================

            System.out.println();
            System.out.println("==========================================");
            System.out.println("     UNIVERSITY CAMPUS SYSTEM");
            System.out.println("==========================================");
            System.out.println("1.  Add Student Record");
            System.out.println("2.  Update Student Record");
            System.out.println("3.  Delete Student Record");
            System.out.println("4.  Display All Records");
            System.out.println("5.  Add Service Request");
            System.out.println("6.  Process Service Request");
            System.out.println("7.  Display Recent Actions");
            System.out.println("8.  Display Students using BST");
            System.out.println("9.  Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection");
            System.out.println("13. Remove Campus Connection");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. BFS Campus Traversal");
            System.out.println("16. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");

            // ==========================================
            // MENU INPUT VALIDATION
            // ==========================================

            if (!scanner.hasNextInt()) {

                System.out.println(
                        "Invalid input. Please enter a number from 1 to 16."
                );

                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ==========================================
                // 1. ADD STUDENT
                // ==========================================

                case 1:

                    System.out.println();
                    System.out.println(
                            "========== ADD STUDENT RECORD =========="
                    );

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println(
                                "Student ID cannot be empty."
                        );
                        break;
                    }

                    // Check duplicate Student ID
                    if (studentList.searchStudent(studentId) != null) {

                        System.out.println(
                                "Student ID already exists."
                        );

                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {

                        System.out.println(
                                "Student name cannot be empty."
                        );

                        break;
                    }

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();

                    if (programme.isEmpty()) {

                        System.out.println(
                                "Programme cannot be empty."
                        );

                        break;
                    }

                    double marks;

                    while (true) {

                        System.out.print(
                                "Enter Marks (0 - 100): "
                        );

                        if (!scanner.hasNextDouble()) {

                            System.out.println(
                                    "Invalid marks. Please enter a number."
                            );

                            scanner.nextLine();
                            continue;
                        }

                        marks = scanner.nextDouble();
                        scanner.nextLine();

                        if (marks < 0 || marks > 100) {

                            System.out.println(
                                    "Invalid marks. Marks must be between 0 and 100."
                            );

                        } else {

                            break;
                        }
                    }

                    Student newStudent = new Student(
                            studentId,
                            name,
                            programme,
                            marks
                    );

                    // Add to Linked List
                    studentList.addStudent(newStudent);

                    // Add to BST
                    studentBST.insertStudent(newStudent);

                    // Add to Hash Table
                    hashTable.addStudent(newStudent);

                    // Record action in Stack
                    actionStack.pushAction(
                            "Added student: " + studentId
                    );

                    System.out.println(
                            "Student record added successfully."
                    );

                    break;

                // ==========================================
                // 2. UPDATE STUDENT
                // ==========================================

                case 2:

                    System.out.println();
                    System.out.println(
                            "========== UPDATE STUDENT =========="
                    );

                    System.out.print("Enter Student ID: ");
                    String updateId = scanner.nextLine().trim();

                    Student existingStudent =
                            studentList.searchStudent(updateId);

                    if (existingStudent == null) {

                        System.out.println(
                                "Student not found."
                        );

                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();

                    if (newName.isEmpty()) {

                        System.out.println(
                                "Name cannot be empty."
                        );

                        break;
                    }

                    System.out.print("Enter New Programme: ");
                    String newProgramme =
                            scanner.nextLine().trim();

                    if (newProgramme.isEmpty()) {

                        System.out.println(
                                "Programme cannot be empty."
                        );

                        break;
                    }

                    double newMarks;

                    while (true) {

                        System.out.print(
                                "Enter New Marks (0 - 100): "
                        );

                        if (!scanner.hasNextDouble()) {

                            System.out.println(
                                    "Invalid marks. Please enter a number."
                            );

                            scanner.nextLine();
                            continue;
                        }

                        newMarks = scanner.nextDouble();
                        scanner.nextLine();

                        if (newMarks < 0 || newMarks > 100) {

                            System.out.println(
                                    "Marks must be between 0 and 100."
                            );

                        } else {

                            break;
                        }
                    }

                    studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks
                    );

                    actionStack.pushAction(
                            "Updated student: " + updateId
                    );

                    break;

                // ==========================================
                // 3. DELETE STUDENT
                // ==========================================

                 case 3:

    System.out.println();
    System.out.println(
            "========== DELETE STUDENT =========="
    );

    System.out.print("Enter Student ID: ");

    String deleteId = scanner.nextLine().trim();

    if (studentList.searchStudent(deleteId) == null) {

        System.out.println(
                "Student not found."
        );

        break;
    }

    // Delete from Linked List
    studentList.deleteStudent(deleteId);

    // Delete from BST
    studentBST.deleteStudent(deleteId);

    // Delete from Hash Table
    hashTable.deleteStudent(deleteId);

    // Record action
    actionStack.pushAction(
            "Deleted student: " + deleteId
    );

    System.out.println(
            "Student deleted successfully from all data structures."
    );

    break; 
   

                // ==========================================
                // 4. DISPLAY ALL STUDENTS
                // ==========================================

                case 4:

                    System.out.println();

                    studentList.displayStudents();

                    break;

                // ==========================================
                // 5. ADD SERVICE REQUEST
                // ==========================================

                case 5:

                    System.out.println();
                    System.out.println(
                            "========== ADD SERVICE REQUEST =========="
                    );

                    System.out.print(
                            "Enter Service Request: "
                    );

                    String request =
                            scanner.nextLine().trim();

                    if (request.isEmpty()) {

                        System.out.println(
                                "Service request cannot be empty."
                        );

                        break;
                    }

                    serviceQueue.addRequest(request);

                    actionStack.pushAction(
                            "Added service request"
                    );

                    break;

                // ==========================================
                // 6. PROCESS SERVICE REQUEST
                // ==========================================

                case 6:

                    System.out.println();
                    System.out.println(
                            "========== PROCESS SERVICE REQUEST =========="
                    );

                    serviceQueue.processNextRequest();

                    break;

                // ==========================================
                // 7. DISPLAY RECENT ACTIONS
                // ==========================================

                case 7:

                    System.out.println();

                    actionStack.displayActions();

                    break;

                // ==========================================
                // 8. DISPLAY BST
                // ==========================================

                case 8:

                    System.out.println();

                    studentBST.displayStudents();

                    break;

                // ==========================================
                // 9. SEARCH USING HASHING
                // ==========================================

                case 9:

                    System.out.println();
                    System.out.println(
                            "========== SEARCH STUDENT =========="
                    );

                    System.out.print(
                            "Enter Student ID: "
                    );

                    String searchId =
                            scanner.nextLine().trim();

                    Student foundStudent =
                            hashTable.searchStudent(searchId);

                    if (foundStudent == null) {

                        System.out.println(
                                "Student not found in Hash Table."
                        );

                    } else {

                        System.out.println(
                                "Student found:"
                        );

                        foundStudent.displayStudent();
                    }

                    break;

                // ==========================================
                // 10. ADD CAMPUS LOCATION
                // ==========================================

                case 10:

                    System.out.println();
                    System.out.println(
                            "========== ADD CAMPUS LOCATION =========="
                    );

                    System.out.print(
                            "Enter Location Name: "
                    );

                    String location =
                            scanner.nextLine().trim();

                    campusGraph.addLocation(location);

                    break;

                // ==========================================
                // 11. REMOVE CAMPUS LOCATION
                // ==========================================

                case 11:

                    System.out.println();
                    System.out.println(
                            "========== REMOVE CAMPUS LOCATION =========="
                    );

                    System.out.print(
                            "Enter Location Name: "
                    );

                    String removeLocation =
                            scanner.nextLine().trim();

                    campusGraph.removeLocation(
                            removeLocation
                    );

                    break;

                // ==========================================
                // 12. ADD CAMPUS CONNECTION
                // ==========================================

                case 12:

                    System.out.println();
                    System.out.println(
                            "========== ADD CAMPUS CONNECTION =========="
                    );

                    System.out.print(
                            "Enter First Location: "
                    );

                    String location1 =
                            scanner.nextLine().trim();

                    System.out.print(
                            "Enter Second Location: "
                    );

                    String location2 =
                            scanner.nextLine().trim();

                    campusGraph.addConnection(
                            location1,
                            location2
                    );

                    break;

                // ==========================================
                // 13. REMOVE CAMPUS CONNECTION
                // ==========================================

                case 13:

                    System.out.println();
                    System.out.println(
                            "========== REMOVE CAMPUS CONNECTION =========="
                    );

                    System.out.print(
                            "Enter First Location: "
                    );

                    String location3 =
                            scanner.nextLine().trim();

                    System.out.print(
                            "Enter Second Location: "
                    );

                    String location4 =
                            scanner.nextLine().trim();

                    campusGraph.removeConnection(
                            location3,
                            location4
                    );

                    break;

                // ==========================================
                // 14. DISPLAY CAMPUS CONNECTIONS
                // ==========================================

                case 14:

                    System.out.println();

                    campusGraph.displayConnections();

                    break;

                // ==========================================
                // 15. BFS TRAVERSAL
                // ==========================================

                case 15:

                    System.out.println();
                    System.out.println(
                            "========== BFS CAMPUS TRAVERSAL =========="
                    );

                    System.out.print(
                            "Enter Starting Location: "
                    );

                    String startLocation =
                            scanner.nextLine().trim();

                    campusGraph.bfs(startLocation);

                    break;

                // ==========================================
                // 16. EXIT
                // ==========================================

                case 16:

                    System.out.println();
                    System.out.println(
                            "Thank you for using University Campus System."
                    );

                    break;

                // ==========================================
                // INVALID CHOICE
                // ==========================================

                default:

                    System.out.println(
                            "Invalid choice. Please select 1 to 16."
                    );
            }

        } while (choice != 16);

        scanner.close();
    }
}