import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListQuerySolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read number of lists
            int n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Number of lists must be positive.");
                return;
            }

            // Create a list of lists
            List<List<Integer>> lists = new ArrayList<>();

            // Read each list
            for (int i = 0; i < n; i++) {
                int size = sc.nextInt();
                if (size < 0) {
                    System.out.println("List size cannot be negative.");
                    return;
                }
                List<Integer> innerList = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    innerList.add(sc.nextInt());
                }
                lists.add(innerList);
            }

            // Read number of queries
            int q = sc.nextInt();
            if (q < 0) {
                System.out.println("Number of queries cannot be negative.");
                return;
            }

            // Process each query
            for (int i = 0; i < q; i++) {
                int listIndex = sc.nextInt();
                int elementIndex = sc.nextInt();

                // Validate indices (1-based indexing in problem)
                if (listIndex <= 0 || listIndex > lists.size()) {
                    System.out.println("ERROR!");
                } else {
                    List<Integer> selectedList = lists.get(listIndex - 1);
                    if (elementIndex <= 0 || elementIndex > selectedList.size()) {
                        System.out.println("ERROR!");
                    } else {
                        System.out.println(selectedList.get(elementIndex - 1));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input format.");
        } finally {
            sc.close();
        }
    }
}
