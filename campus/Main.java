package campus;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // 1. CREATE STUDENTS
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


        // ==========================================
        // 2. LINKED LIST
        // ==========================================

        System.out.println("\n========== LINKED LIST ==========");

        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);
        studentList.addStudent(student4);

        studentList.displayStudents();


        // ==========================================
        // 3. STACK
        // ==========================================

        System.out.println("\n========== STACK ==========");

        ActionStack actionStack = new ActionStack();

        actionStack.pushAction("Added Student 23DA2-0872");
        actionStack.pushAction("Added Student 23DA2-0662");
        actionStack.pushAction("Updated Student 23DA2-0872");
        actionStack.pushAction("Deleted Student 23DA2-0946");

        actionStack.displayActions();
        actionStack.viewLastAction();


        // ==========================================
        // 4. QUEUE
        // ==========================================

        System.out.println("\n========== QUEUE ==========");

        ServiceQueue serviceQueue = new ServiceQueue();

        serviceQueue.addRequest(
                "23DA2-0872 -> Transcript Request"
        );

        serviceQueue.addRequest(
                "23DA2-0662 -> ID Card Request"
        );

        serviceQueue.addRequest(
                "23DA2-0946 -> Registration Request"
        );

        serviceQueue.displayRequests();

        serviceQueue.processNextRequest();

        serviceQueue.displayRequests();


        // ==========================================
        // 5. BINARY SEARCH TREE
        // ==========================================

        System.out.println("\n========== BINARY SEARCH TREE ==========");

        StudentBST studentBST = new StudentBST();

        studentBST.insertStudent(student1);
        studentBST.insertStudent(student2);
        studentBST.insertStudent(student3);
        studentBST.insertStudent(student4);

        studentBST.displayStudents();

        Student bstResult =
                studentBST.searchStudent("23DA2-0662");

        if (bstResult != null) {

            System.out.println("BST Search Result:");
            bstResult.displayStudent();

        } else {

            System.out.println("Student not found in BST.");
        }


        // ==========================================
        // 6. HASH TABLE
        // ==========================================

        System.out.println("\n========== HASH TABLE ==========");

        StudentHashTable studentHashTable =
                new StudentHashTable();

        studentHashTable.addStudent(student1);
        studentHashTable.addStudent(student2);
        studentHashTable.addStudent(student3);
        studentHashTable.addStudent(student4);

        studentHashTable.displayHashTable();

        Student hashResult =
                studentHashTable.searchStudent("23DA2-0662");

        if (hashResult != null) {

            System.out.println("Hash Search Result:");
            hashResult.displayStudent();

        } else {

            System.out.println("Student not found in Hash Table.");
        }


        // ==========================================
        // 7. CAMPUS GRAPH
        // ==========================================

        System.out.println("\n========== CAMPUS GRAPH ==========");

        CampusGraph campusGraph = new CampusGraph();

        campusGraph.addLocation("Library");
        campusGraph.addLocation("Cafeteria");
        campusGraph.addLocation("Main Gate");
        campusGraph.addLocation("Lecture Hall");

        campusGraph.addConnection(
                "Library",
                "Cafeteria"
        );

        campusGraph.addConnection(
                "Cafeteria",
                "Main Gate"
        );

        campusGraph.addConnection(
                "Cafeteria",
                "Lecture Hall"
        );

        campusGraph.displayConnections();


        // ==========================================
        // 8. BFS
        // ==========================================

        System.out.println("\n========== BFS ==========");

        campusGraph.bfs("Library");


        // ==========================================
        // 9. TESTING
        // ==========================================

        System.out.println("\n========== TESTING ==========");


        // Test 1: Search Student

        System.out.println("\n--- Test 1: Search Student ---");

        Student searchResult =
                studentList.searchStudent("23DA2-0662");

        if (searchResult != null) {

            System.out.println("Student found:");
            searchResult.displayStudent();

        } else {

            System.out.println("Student not found.");
        }


        // Test 2: Update Student

        System.out.println("\n--- Test 2: Update Student ---");

        studentList.updateStudent(
                "23DA2-0662",
                "MF FASEERA",
                "BAIT",
                88
        );


        // Test 3: Delete Student

        System.out.println("\n--- Test 3: Delete Student ---");

        studentList.deleteStudent("23DA2-0946");


        // Test 4: Search Deleted Student

        System.out.println("\n--- Test 4: Search Deleted Student ---");

        Student deletedStudent =
                studentList.searchStudent("23DA2-0946");

        if (deletedStudent == null) {

            System.out.println(
                    "Deleted student not found - Test Passed."
            );

        } else {

            System.out.println(
                    "Student still exists - Test Failed."
            );
        }


        // Test 5: Duplicate Student ID

        System.out.println("\n--- Test 5: Duplicate Student ID ---");

        Student duplicateStudent = new Student(
                "23DA2-0872",
                "Duplicate Student",
                "BAIT",
                70
        );

        studentList.addStudent(duplicateStudent);


        // Test 6: Invalid Graph Connection

        System.out.println(
                "\n--- Test 6: Invalid Graph Connection ---"
        );

        campusGraph.addConnection(
                "Library",
                "Unknown Location"
        );


        // Test 7: Invalid BFS Location

        System.out.println(
                "\n--- Test 7: Invalid BFS Location ---"
        );

        campusGraph.bfs("Unknown Location");


        // ==========================================
        // PROGRAM COMPLETED
        // ==========================================

        System.out.println("\n================================");
        System.out.println("   PROGRAM COMPLETED SUCCESSFULLY");
        System.out.println("================================");
    }
}