import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();
        Integer[] sortedCoins = coins.clone();
        Arrays.sort(sortedCoins, Collections.reverseOrder());
        int count = 0;
        for (int coin : sortedCoins) {
            count += K / coin;
            K %= coin;
            if (K == 0)
                break;
        }
        System.out.print(count);
    }
}