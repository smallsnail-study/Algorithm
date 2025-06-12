import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int count3kg = 0;
        
        while ((n % 5) != 0 && n >= 0) {
            n -= 3;
            count3kg++;
        }
        
        if (n < 0) {
            System.out.print(-1);
        } else {
            System.out.print((n / 5) + count3kg);
        }
    }
}