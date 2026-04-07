import java.util.Scanner;

public class JavaSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read the number of elements
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[n];

            // Read array elements
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int negativeCount = 0;

            // Check all subarrays
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int end = start; end < n; end++) {
                    sum += arr[end];
                    if (sum < 0) {
                        negativeCount++;
                    }
                }
            }

            // Output the result
            System.out.println(negativeCount);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}
