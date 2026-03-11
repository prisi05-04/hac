import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BigInteger n = scan.nextBigInteger();
        scan.close();
       
        if (n.isProbablePrime(10)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
