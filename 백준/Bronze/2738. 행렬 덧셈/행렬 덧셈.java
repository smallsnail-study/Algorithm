import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        int[][] result = new int[N][M];
        for (int k = 0; k < N * M; k++) {
            int i = k / M;
            int j = k % M;
            result[i][j] = A[i][j] + B[i][j];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
                if (j < M - 1)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    } 
}