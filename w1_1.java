import java.util.*;

public class w1_1 {
    public static int winCount(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (mubius(x[i]) > 0) count++;
        }
        return count;
    }

    public static int mubius(int n) {
        if (n == 1) return 1;

        int primeCount = 0;
        int tmp = n;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) { 
                for (int j = i * 2; j <= n; j += i) isPrime[j] = false; 
                if (tmp % i == 0) {
                    tmp /= i;
                    primeCount++;
                    if (tmp % i == 0) return 0; 
                }
            }
        }
        return (primeCount % 2 == 0) ? 1 : -1;
    }

    public static int[] input(String str, int n) {
        String[] parts = str.trim().split("\\s+");
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(parts[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        int[][] x = new int[n][];
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            x[i] = input(tmp, n);
        }

        int[] count = new int[n];
        int indexMax = 0;

        for (int i = 0; i < n; i++) {
            count[i] = winCount(x[i]);
            if (count[i] > count[indexMax]) indexMax = i;
        }

        System.out.println(indexMax);
        scanner.close();
    }
}
