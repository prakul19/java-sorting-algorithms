import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;

            // Shift elements of the sorted part to make space for the key
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key; // Insert the key at the correct position
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of employees:");
            int n = scanner.nextInt();
            int[] ids = new int[n];

            System.out.println("Enter the employee IDs:");
            for (int i = 0; i < n; i++) {
                ids[i] = scanner.nextInt();
            }

            insertionSort(ids);

            System.out.println("Sorted employee IDs:");
            for (int id : ids) {
                System.out.print(id + " ");
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
Enter the number of employees:
5
Enter the employee IDs:
105 101 103 102 104

Output:
Sorted employee IDs:
101 102 103 104 105
 */