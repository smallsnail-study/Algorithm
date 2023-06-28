import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 바퀴의 칸의 수
        int K = sc.nextInt(); // 바퀴를 돌리는 횟수

        char[] wheel = new char[N];
        // 배열을 모두 ?로 채운다.배열에 같은값을 채우는 함수 Arrays.fill()
        Arrays.fill(wheel, '?');

        // 화살표의 위치
        int curIndex = 0;
        while (K-- > 0) {
            int step = sc.nextInt(); // 시계방향으로 몇칸이나 회전하는지
            char nextAlphabet = sc.next().charAt(0); // 회전 후의 화살표가 가리키고 있는 알파벳

            // step만큼 바퀴가 시계방향으로 회전한 후,그 다음 순간 화살표는 어떤 인덱스를 가리키고 있는지 확인
            int nextIndex = ((curIndex - step) % N + N) % N;
            if (wheel[nextIndex]== '?') wheel[nextIndex] = nextAlphabet;
            else if (wheel[nextIndex] != nextAlphabet) {
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            // ArraysOutOfIndex룰 방지하기 위한 설정
            if (wheel[i] == '?') continue;
            if (used[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            used[wheel[i] - 'A'] = true;
        }
        for (int i = 0; i < N; i++)
            System.out.print(wheel[(curIndex + i) % N]);
        System.out.println();
    }
}