import java.util.Scanner;

public class SelectionSortExamScores {

    // Method to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the first unsorted element is the smallest
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            // Swap the smallest element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of students:");
            int n = scanner.nextInt();
            int[] scores = new int[n];

            System.out.println("Enter the exam scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }

            selectionSort(scores);

            System.out.println("Sorted exam scores:");
            for (int score : scores) {
                System.out.print(score + " ");
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
Enter the exam scores:
78 85 62 90 70

Output:
Sorted exam scores:
62 70 78 85 90
 */