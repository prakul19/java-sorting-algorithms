import java.util.Scanner;

public class BubbleSortStudentMarks {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) { // Swap if elements are out of order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Exit if no swaps occurred
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of students:");
            int n = scanner.nextInt();
            int[] marks = new int[n];

            System.out.println("Enter the marks of students:");
            for (int i = 0; i < n; i++) {
                marks[i] = scanner.nextInt();
            }

            bubbleSort(marks);

            System.out.println("Sorted marks:");
            for (int mark : marks) {
                System.out.print(mark + " ");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/*
Input:
Enter the number of students:
5
Enter the marks of students:
45 67 23 89 12

Output:
Sorted marks:
12 23 45 67 89
 */