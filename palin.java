import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();
        boolean result = isPalindrome(x);
        System.out.println(result);
        sc.close();
    }

    public static boolean isPalindrome(int x) {
       
        if (x < 0) {
            return false;
        }
        
       
        String str = Integer.toString(x);
        
       
        int left = 0;
        int right = str.length() - 1;

       
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;  
            }
            left++;
            right--;
        }
        
        return true;  
    }
}
