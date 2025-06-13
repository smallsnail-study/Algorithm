import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
        }
        sc.close();
        
        int[] timesSort = times.clone();
        Arrays.sort(timesSort);
        int ans = 0;
        
        for (int i = 0; i < timesSort.length; i++) {
            ans += timesSort[i] * (N - i);
        }
        System.out.print(ans);
    }
}