import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();   // 테스트 케이스의 수 P (1 ≤ P ≤ 1000)
        // O(P)
        while (P-- > 0) {
            int T = sc.nextInt();   // 테스트 케이스 번호
            int[] h = new int[20];  // 학생들이 저장되어 있는 배열
            // O(N)
            for (int i = 0; i < 20; i++)
                h[i] = sc.nextInt();

            int cnt = 0;    // 뒤로 물러난 걸음 수 총합
            int[] sorted = new int[20]; // 학생들이 정렬되어 있는 배열
            // O(N^)
            for (int i = 0; i < 20; i++) {
                // 1. 줄 서 있는 학생들 중에 자신보다 큰 학생을 찾는다.
                boolean find = false;
                for (int j = 0; j < i; j++)
                    if (sorted[j] > h[i]) {
                        // 2. 찾았다면, 그 학생의 앞에 선다.
                        // 3. 그 학생과 그 학생 뒤의 학생이 모두 한칸씩 물러난다.
                        find = true;
                        for (int k = i - 1; k >= j; k--) {// 나보다 큰 학생은 j번째에 위치 / 그 뒤의 학생들은 내가 i번째에 있으므로 i-1번째까지 위치/
                            // 배열의 특징 때문에 뒤에서부터 계산해줘야 한다.
                            sorted[k + 1] = sorted[k];
                            cnt++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                // 1-1. 찾지 못했다면, 줄의 가장 뒤에 선다.
                if (!find) sorted[i] = h[i];
            }
            // 전체 시간복잡도 : O(P * N^)
            System.out.println(T + " " + cnt);
        }
    }
}