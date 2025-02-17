import java.util.*;

public class w1_4 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int maximum(ArrayList<Integer> list) {
        int m = Integer.MIN_VALUE; 
        for (int a : list) {
            m = a>m ? a : m;  
        }
        return m; 
    }

    public static int firstValidColor(ArrayList<Integer> impsble_colors) { 
        int m ; 
        if (impsble_colors.isEmpty()) {
            m = 1; 
        } 
        else m = maximum(impsble_colors);
        for (int i = 1; i<m; i++) {
            if (!impsble_colors.contains(i)) return i; 
        }
        return m+1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int n = scanner.nextInt() + 1; 
        scanner.close();
        int last_color = 1; 
        int[] colorOf = new int[n+1]; 
        ArrayList<Integer> colors = new ArrayList<>(); 
        // HashMap<Integer, boolean[]> impossibleColors = new HashMap<>();
        ArrayList<Integer>[] impossible = new ArrayList[n+1];
        for (int i = 1; i<=n; i++) {
            impossible[i] = new ArrayList<>(); 
        }


        colorOf[1] = 1;

        for (int i = 2; i<=n; i++) {
            colorOf[i] = firstValidColor(impossible[i]); 
            colors.add(colorOf[i]); 
            if (isPrime(i)) {
                for (int j = 2; i*j<=n; j++) {
                    impossible[i*j].add(colorOf[i]); 
                }
            }
        }

        System.out.println(maximum(colors));
        for (int i = 1; i<=n; i++) {
            System.out.print(colorOf[i] + " ");
        }
    }
}
