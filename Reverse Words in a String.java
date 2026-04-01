import java.util.Scanner;

public class Main {
    public static String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }
        
        // Split by one or more whitespace characters
        String[] words = s.trim().split("\\s+");
        
        StringBuilder result = new StringBuilder();
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(reverseWords(s));
        }
        sc.close();
    }
}
