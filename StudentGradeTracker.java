import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeTracker {
    
    static class StudentSummary {
        String name;
        double average;
        int highest;
        int lowest;

        StudentSummary(String name, double average, int highest, int lowest) {
            this.name = name;
            this.average = average;
            this.highest = highest;
            this.lowest = lowest;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StudentSummary> summaries = new ArrayList<>();

        System.out.print("Total Number of Students : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\n Name of the Students : ");
            String name = sc.nextLine();

            System.out.print("No. of Subjects: ");
            int subjects = sc.nextInt();

            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < subjects; j++) {
                System.out.print("Marks of " + (j + 1) + " Subjects: ");
                int mark = sc.nextInt();
                sum += mark;
                if (mark > max) max = mark;
                if (mark < min) min = mark;
            }
            sc.nextLine(); // buffer clear

            double average = (double) sum / subjects;

            System.out.println("\n=== Report for " + name + " ===");
            System.out.println("Average: " + average);
            System.out.println("Highest: " + max);
            System.out.println("Lowest: " + min);
            System.out.println("------------------------------");

            
            summaries.add(new StudentSummary(name, average, max, min));
        }

        
        System.out.println("\n==== Summary Report of All Students ====");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Name", "Average", "Highest", "Lowest");
        for (StudentSummary s : summaries) {
            System.out.printf("%-15s %-10.2f %-10d %-10d%n",
                    s.name, s.average, s.highest, s.lowest);
        }

        sc.close();
    }
}
