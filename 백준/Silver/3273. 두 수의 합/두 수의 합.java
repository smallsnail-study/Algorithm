import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        첫째 줄에 수열의 크기 n이 주어진다.
//        다음 줄에는 수열에 포함되는 수가 주어진다.
//        셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        int X = sc.nextInt();

        boolean[] exist = new boolean[1000001];
        for(int i = 0; i < N; i++)
            exist[a[i]] = true;

        int ans = 0;
        for (int i = 0; i <= (X - 1) / 2; i++) {
            if (i <= 1000000 && X - i <= 1000000)
                ans += (exist[i] && exist[X - i]) ? 1 : 0;
        }
        System.out.println(ans);
    }
}