public class Student {

    private int rollNo;
    private String name;
    private double marks;
    private String grade;

    // Constructor
    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Calculate Grade
    private String calculateGrade() {

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    // Convert student object to file format
    public String toFileString() {
        return rollNo + "," + name + "," + marks;
    }

    // Display student details
    public void displayStudent() {
        System.out.printf("%-10d %-20s %-10.2f %-5s%n",
                rollNo, name, marks, grade);
    }
}