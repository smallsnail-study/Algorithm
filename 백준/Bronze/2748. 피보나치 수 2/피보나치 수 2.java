import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        long a = 0;
        long b = 1;
        
        if (n == 0) {
            System.out.print(a);
        } else if (n == 1) {
            System.out.print(b);
        } else {
            for (int i = 2; i < n+1; i++) {
                long tmp = b;
                b = a + b;
                a = tmp;
            }
            System.out.print(b);
        }
    }
}