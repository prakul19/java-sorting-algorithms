import java.util.Scanner;

public class CountingSortStudentAges {

    // Method to perform Counting Sort
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        int[] count = new int[range]; // Count array to store frequency
        int[] output = new int[ages.length]; // Output array for sorted ages

        // Count the frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in the correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted array back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of students:");
            int n = scanner.nextInt();
            int[] ages = new int[n];

            System.out.println("Enter the ages of students (between 10 and 18):");
            for (int i = 0; i < n; i++) {
                ages[i] = scanner.nextInt();
                if (ages[i] < 10 || ages[i] > 18) {
                    throw new Exception("Age must be between 10 and 18");
                }
            }

            countingSort(ages);

            System.out.println("Sorted ages:");
            for (int age : ages) {
                System.out.print(age + " ");
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
6
Enter the ages of students (between 10 and 18):
12 18 14 10 15 12

Output:
Sorted ages:
10 12 12 14 15 18
 */