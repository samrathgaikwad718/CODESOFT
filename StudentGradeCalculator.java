import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    System.out.println("Enter marks for Subject " + (i + 1) + ": ");
                    marks[i] = scanner.nextInt();
                    if (marks[i] < 0 || marks[i] > 100) {
                        System.out.println("Marks must be between 0 and 100. Please try again.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (totalMarks / 500.0) * 100;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Student Name: " + name);
        System.out.println("Total Marks: " + totalMarks + "/500");
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

