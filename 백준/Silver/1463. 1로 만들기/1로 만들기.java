import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] dp = new int[N + 1];
        
        for (int i = 2; i < N + 1; i++) {
            int minSteps = dp[i - 1] + 1;
            if (i % 3 == 0) {
                minSteps = Math.min(minSteps, dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                minSteps = Math.min(minSteps, dp[i / 2] + 1);
            }
            dp[i] = minSteps;
        }
        System.out.print(dp[N]);
    }
}