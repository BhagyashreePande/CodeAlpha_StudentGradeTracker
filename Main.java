import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("        STUDENT GRADE TRACKER SYSTEM");
            System.out.println("=================================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Calculate Average Score");
            System.out.println("6. Display Highest Score");
            System.out.println("7. Display Lowest Score");
            System.out.println("8. Display Summary Report");
            System.out.println("9. Exit");
            System.out.println("=================================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    double marks;

                    while (true) {

                        System.out.print("Enter Marks (0-100): ");
                        marks = sc.nextDouble();

                        if (marks >= 0 && marks <= 100)
                            break;

                        System.out.println("Invalid Marks! Please enter between 0 and 100.");
                    }

                    Student student = new Student(rollNo, name, marks);
                    tracker.addStudent(student);
                    break;

                case 2:

                    System.out.print("Enter Roll Number to Search: ");
                    tracker.searchStudent(sc.nextInt());
                    break;

                case 3:

                    System.out.print("Enter Roll Number to Delete: ");
                    tracker.deleteStudent(sc.nextInt());
                    break;

                case 4:

                    tracker.displayAllStudents();
                    break;

                case 5:

                    tracker.calculateAverage();
                    break;

                case 6:

                    tracker.highestScore();
                    break;

                case 7:

                    tracker.lowestScore();
                    break;

                case 8:

                    tracker.summaryReport();
                    break;

                case 9:

                    System.out.println("\nThank you for using Student Grade Tracker System!");
                    break;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}