import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            stairs[i] = sc.nextInt();
        }
        sc.close();
        
        if (n == 1) {
            System.out.print(stairs[1]);
            return;
        }
        
        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }
        System.out.print(dp[n]);
    }
}