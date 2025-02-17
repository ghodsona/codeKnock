import java.util.*; 

public class w2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int n = scanner.nextInt(); 
        int q = scanner.nextInt(); 
        // String numbers = scanner.nextLine();
        // String[] num = numbers.split(" "); 
        int[] a = new int[n]; 
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] ans = new int[q];  
        for (int i = 0; i<q; i++) {
            int start = scanner.nextInt()-1; 
            int end = scanner.nextInt()-1;
            for (int j = start; j<=end; j++) {
                ans[i] += a[j]; 
            }
        }

        for (int i = 0; i<q; i++) {
            System.out.println(ans[i]);
        }
    }
}
