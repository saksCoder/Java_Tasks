import java.util.*;

class GradingSystemMenu {

    static Scanner scanner = new Scanner(System.in);

    // Printing Welcome Message
    public static void welcomeMessage() {
        System.out.println("||Welcome to the Grade Management System||");
    }

    // Printing Exit Message
    public static void exitMessage() {
        System.out.println("\n\n\n||Thank You for using Grade Management System||");
    }

    // Menu of the Program
    public static void getMenuItem() {
        System.out.println("1. Enter student's record");
        System.out.println("2. Display all students grade");
        System.out.println("3. Display Statistics");
        System.out.println("4. Exit the application");
        System.out.println("Please enter your choice : ");
    }

    public static boolean isStudentValueEmpty(String value, String label) {
        if (value.isEmpty() || value == null) { // check if value is empty string
            System.out.println("Error - " + label + " must not be empty");
            return true;
        }
        return false;

    }

    public static boolean isStudentMarksBetweenRange(double value, String label, double maxValue) {
        if (value < 0 || value > maxValue) {
            System.out.println("Error - " + label + " marks be between 0-" + maxValue + "%");
            return true;
        }
        return false;
    }

    // Display Student's details after entering
    public static void displayStudentEnteredDetails(Student student) {
        System.out.println("\nDetails for record 1 enterd -");
        System.out.println("\nStudent Name \tStudent Number \tAssignment One \tAssignment Two \tFinal Project");
        System.out.println(
                student.getStudentName() + "\t\t" + student.getStudentID() + "\t\t" + student.getAssignmentOneMarks()
                        + "\t\t" + student.getAssignmentTwoMarks() + "\t\t" + student.getProjectMark());
    }

    // Display total student's details
    public static void displayAllRecordsWithGrade(Student students[], int totalStudentCount) {
        System.out.println("\nStudent Name \tStudent Number \tAssignment One \tAssignment Two \tFinal Project \tGrade");
        for (int i = 0; i < totalStudentCount; i++) {
            System.out.println(
                    students[i].getStudentName() + "\t\t" + students[i].getStudentID() + "\t\t"
                            + students[i].getAssignmentOneMarks() + "\t\t" + students[i].getAssignmentTwoMarks()
                            + "\t\t" + students[i].getProjectMark() + "\t\t" + students[i].calculateGrade() + "\n");
        }
    }

    public static void displayStatistics(Student students[], int totalStudentCount) { // method for calculating
        // statistics
        double minTotalStudentMark = students[0].calculateIndividualTotalMarks();
        String minTotalStudentName = students[0].getStudentName();
        String minTotalStudentGrade = students[0].calculateGrade();

        double maxTotalStudentMark = students[0].calculateIndividualTotalMarks();
        String maxTotalStudentName = students[0].getStudentName();
        String maxTotalStudentGrade = students[0].calculateGrade();

        double totalStudentMarks = 0.0;

        for (int i = 0; i < totalStudentCount; i++) {
            // finding max
            if (maxTotalStudentMark < students[i].calculateIndividualTotalMarks()) {
                maxTotalStudentMark = students[i].calculateIndividualTotalMarks();
                maxTotalStudentName = students[i].getStudentName();
                maxTotalStudentGrade = students[i].calculateGrade();
            }
            // finding min
            if (minTotalStudentMark > students[i].calculateIndividualTotalMarks()) {
                minTotalStudentMark = students[i].calculateIndividualTotalMarks();
                minTotalStudentName = students[i].getStudentName();
                minTotalStudentGrade = students[i].calculateGrade();
            }
            // Total marks
            totalStudentMarks += students[i].calculateIndividualTotalMarks();

            System.out.println(maxTotalStudentName + " has the maximum total marks of " + maxTotalStudentMark
                    + " with grade " + maxTotalStudentGrade);
            System.out.println(minTotalStudentName + " has the minimum total marks of " + minTotalStudentMark
                    + " with grade " + minTotalStudentGrade);
            System.out.println(
                    "Average total marks of entire chart is " + (totalStudentMarks / totalStudentCount));
        }

    }

    public static int enterStudentRecord(Student students[], int totalStudentCount) {

        if (totalStudentCount >= 10) {
            System.out.println("Error - maximum record to be entered has been reached");
            return totalStudentCount;
        }

        String studentName, studentId;
        double assignementOneMarks, assignementTwoMarks;
        double projectMark;
        do {
            System.out.print("\nPlease enter the student name ===> ");
            studentName = scanner.nextLine();

        } while (isStudentValueEmpty(studentName, "Name"));

        do {
            System.out.print("\nPlease enter the student number ===> ");
            studentId = scanner.nextLine();

        } while (isStudentValueEmpty(studentId, "Number"));

        do {
            System.out.print("\nPlease enter your assignment one marks including decimal values ===> ");
            assignementOneMarks = scanner.nextDouble();

        } while (isStudentMarksBetweenRange(assignementOneMarks, "Assignment one", 20));

        do {
            System.out.print("\nPlease enter your assignment two marks including decimal values ===> ");
            assignementTwoMarks = scanner.nextDouble();

        } while (isStudentMarksBetweenRange(assignementTwoMarks, "Assignment two", 30));

        do {
            System.out.print("\nPlease enter your Project marks including decimal values ===> ");
            projectMark = scanner.nextDouble();
        } while (isStudentMarksBetweenRange(projectMark, "ProjectMark", 50));

        students[totalStudentCount] = new Student();
        students[totalStudentCount].setStudentName(studentName);
        students[totalStudentCount].setStudentID(studentId);
        students[totalStudentCount].setAssignmentOneMarks(assignementOneMarks);
        students[totalStudentCount].setAssignmentTwoMarks(assignementTwoMarks);
        students[totalStudentCount].setProjectMark(projectMark);

        displayStudentEnteredDetails(students[totalStudentCount]);

        totalStudentCount++;
        System.out.println(totalStudentCount);

        return totalStudentCount;

        // scanner.close();
    }

    public static void main(String[] args) {
        // Setting the max input to 10
        Student students[] = new Student[10];
        int totalStudentCount = 0;
        int choice = 0;

        welcomeMessage();

        do {
            // Retrieving menu items
            getMenuItem();
            // Getting the choice
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    totalStudentCount = enterStudentRecord(students, totalStudentCount);
                    break;

                case 2:
                    if (totalStudentCount == 0) {
                        System.out.println("Error - You must enter at least one record");
                        break;
                    }
                    // Display all records and grade
                    displayAllRecordsWithGrade(students, totalStudentCount);
                    break;

                case 3:
                    if (totalStudentCount == 0) {
                        System.out.println("Error - You must enter at least one record");
                        break;
                    }
                    // Display Statistics
                    displayStatistics(students, totalStudentCount);
                    break;

                case 4:
                    // Exit from the program
                    exitMessage();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

}