import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost = sc.nextInt();
        sc.close();
        
        int change = 1000 - cost;
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;
        
        while (change > 0) {
            for (int coin : coins) {
                if (coin <= change) {
                    change -= coin;
                    count++;
                    break;
                }
            }
        }
        System.out.print(count);
    }
}