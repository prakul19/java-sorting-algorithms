import java.util.Scanner;

public class HeapSortSalaries {

    // Method to build a Max Heap
    public static void buildMaxHeap(int[] salaries, int n, int i) {
        int largest = i; // Initialize the largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest is not root
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected sub-tree
            buildMaxHeap(salaries, n, largest);
        }
    }

    // Method to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            buildMaxHeap(salaries, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the root element
            buildMaxHeap(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of applicants:");
            int n = scanner.nextInt();
            int[] salaries = new int[n];

            System.out.println("Enter the salary demands of applicants:");
            for (int i = 0; i < n; i++) {
                salaries[i] = scanner.nextInt();
            }

            heapSort(salaries);

            System.out.println("Sorted salary demands:");
            for (int salary : salaries) {
                System.out.print(salary + " ");
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
Enter the number of applicants:
5
Enter the salary demands of applicants:
50000 75000 60000 80000 55000

Output:
Sorted salary demands:
50000 55000 60000 75000 80000
 */