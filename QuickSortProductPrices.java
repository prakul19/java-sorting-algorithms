import java.util.Scanner;

public class QuickSortProductPrices {

    // Method to partition the array
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choose the last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        // Swap pivot element with the element at i + 1
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Method to implement Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high); // Partition the array
            quickSort(prices, low, pivotIndex - 1); // Sort the left partition
            quickSort(prices, pivotIndex + 1, high); // Sort the right partition
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of products:");
            int n = scanner.nextInt();
            int[] prices = new int[n];

            System.out.println("Enter the product prices:");
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            quickSort(prices, 0, prices.length - 1);

            System.out.println("Sorted product prices:");
            for (int price : prices) {
                System.out.print(price + " ");
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
Enter the number of products:
5
Enter the product prices:
300 150 200 500 100

Output:
Sorted product prices:
100 150 200 300 500
 */