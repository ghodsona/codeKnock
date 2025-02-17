import java.util.*;

public class w1_2 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isSeqPrime(int a, int b) {
        if (a == b) return false;
        
        int first = Math.min(a, b);
        int sec = Math.max(a, b);
        
        if (!isPrime(first) || !isPrime(sec)) return false;
        
        for (int i = first + 1; i < sec; i++) {
            if (isPrime(i)) return false;
        }
        return true;
    }


    public static int isValidIce(int n) {
        int tmp = n - 1; 
        for (int i = 0; tmp-i>0; i++) {
            if (isSeqPrime(i, tmp-i)) return 1; 
        }
        return 0; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int k = scanner.nextInt(); 
        int n = scanner.nextInt(); 
        scanner.close();

        if (n==0 || n==1) {
            System.out.println("YES");
            return; 
        }

        int count = 0; 
        for (int i = 1; i<n+1; i++) {
            count += isValidIce(i);
        }

        System.out.println(count>=k ? "YES" : "NO");
    }
}
