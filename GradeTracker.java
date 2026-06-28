import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students;

    // Constructor
    public GradeTracker() {
        students = FileManager.loadStudents();
    }

    // Add Student
    public void addStudent(Student student) {

        // Check duplicate Roll Number
        for (Student s : students) {
            if (s.getRollNo() == student.getRollNo()) {
                System.out.println("Roll Number already exists!");
                return;
            }
        }

        students.add(student);

        // Save data
        FileManager.saveStudents(students);

        System.out.println("Student added successfully!");
    }

    // Search Student
    public void searchStudent(int rollNo) {

        for (Student student : students) {

            if (student.getRollNo() == rollNo) {

                System.out.println("\nStudent Found");
                System.out.println("------------------------------------------------------------");
                System.out.printf("%-10s %-20s %-10s %-5s%n",
                        "Roll No", "Student Name", "Marks", "Grade");
                System.out.println("------------------------------------------------------------");

                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int rollNo) {

        for (Student student : students) {

            if (student.getRollNo() == rollNo) {

                students.remove(student);

                // Save updated data
                FileManager.saveStudents(students);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Display All Students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.println("                    STUDENT DETAILS");
        System.out.println("==============================================================");

        System.out.printf("%-10s %-20s %-10s %-5s%n",
                "Roll No", "Student Name", "Marks", "Grade");

        System.out.println("--------------------------------------------------------------");

        for (Student student : students) {
            student.displayStudent();
        }

        System.out.println("==============================================================");
    }
// Calculate Average Score
    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = total / students.size();

        System.out.printf("Average Score : %.2f%n", average);
    }

    // Display Highest Score
    public void highestScore() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student highest = students.get(0);

        for (Student student : students) {
            if (student.getMarks() > highest.getMarks()) {
                highest = student;
            }
        }

        System.out.println("\nHighest Score");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-5s%n",
                "Roll No", "Student Name", "Marks", "Grade");
        System.out.println("--------------------------------------------------------------");

        highest.displayStudent();
    }

    // Display Lowest Score
    public void lowestScore() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student lowest = students.get(0);

        for (Student student : students) {
            if (student.getMarks() < lowest.getMarks()) {
                lowest = student;
            }
        }

        System.out.println("\nLowest Score");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-5s%n",
                "Roll No", "Student Name", "Marks", "Grade");
        System.out.println("--------------------------------------------------------------");

        lowest.displayStudent();
    }

    // Summary Report
    public void summaryReport() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        for (Student student : students) {

            total += student.getMarks();

            if (student.getMarks() > highest)
                highest = student.getMarks();

            if (student.getMarks() < lowest)
                lowest = student.getMarks();
        }

        double average = total / students.size();

        System.out.println("\n==============================================================");
        System.out.println("                 STUDENT SUMMARY REPORT");
        System.out.println("==============================================================");

        System.out.printf("%-10s %-20s %-10s %-5s%n",
                "Roll No", "Student Name", "Marks", "Grade");

        System.out.println("--------------------------------------------------------------");

        for (Student student : students) {
            student.displayStudent();
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Total Students : " + students.size());
        System.out.printf("Average Score  : %.2f%n", average);
        System.out.println("Highest Score  : " + highest);
        System.out.println("Lowest Score   : " + lowest);
        System.out.println("==============================================================");
    }

}