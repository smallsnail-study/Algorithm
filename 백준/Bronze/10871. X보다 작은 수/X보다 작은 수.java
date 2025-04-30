import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int X = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            if (A < X) 
                sb.append(A).append(" ");
        }
        sc.close();
        System.out.print(sb.toString().trim());
    }
}