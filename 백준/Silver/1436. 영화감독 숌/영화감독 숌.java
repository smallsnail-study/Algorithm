import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int cur = 666; // 제일 작은 어둠의 수
        int nDoom = 0; // 몇 번째 어둠의 수인지 체크
        
        while(true) {
            if (isDoom(cur)) {
                nDoom += 1;
            }
            if (nDoom == N) {
                System.out.println(cur);
                break;
            }
            cur += 1;
        }
    }
    
    private static boolean isDoom(int num) {
        return String.valueOf(num).contains("666");
    }
}