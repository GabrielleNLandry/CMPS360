import java.util.Scanner;

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        while (age <= 0) {
            System.out.print("Invalid age. Please enter a positive integer: ");
            age = scanner.nextInt();
        }

        System.out.print("Enter your GPA (0.0 - 4.0): ");
        double gpa = scanner.nextDouble();
        while (gpa < 0.0 || gpa > 4.0) {
            System.out.print("Invalid GPA. Please enter a value between 0.0 and 4.0: ");
            gpa = scanner.nextDouble();
        }

        System.out.print("Enter the number of completed credits: ");
        int completedCredits = scanner.nextInt();

        int[] studyHours = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the hours you study per week for subject " + (i+1) + ": ");
            studyHours[i] = scanner.nextInt();
        }

        int totalStudyHours = 0;
        for (int hours : studyHours) {
            totalStudyHours += hours;
        }
        double avgStudyHoursPerDay = (totalStudyHours / 5.0) / 7.0;
        double totalStudyHoursPerSemester = totalStudyHours * 16;
        int remainingCredits = 120 - completedCredits;

        System.out.println("\n--- Student Summary ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Completed Credits: " + completedCredits);
        System.out.println("Remaining Credits: " + remainingCredits);
        System.out.printf("Average Study Hours Per Day: %.2f\n", avgStudyHoursPerDay);
        System.out.printf("Total Study Hours Per Semester: %.0f\n", totalStudyHoursPerSemester);
    }
}
//test


