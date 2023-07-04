import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바퀴 칸 수
        int K = Integer.parseInt(st.nextToken()); // 바퀴 돌리는 횟수

        char[] wheel = new char[N];
        Arrays.fill(wheel,'?');

        int curIndex = 0;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 회전시켰을 때 화살표가 가리키는 글자가 몇번 바뀌었는지
            char nextAlphabet = st.nextToken().charAt(0); // 멈췄을때 가리키던 글자

            int nextIndex = ((curIndex - S) % N + N) % N;
            if (wheel[nextIndex] == '?') wheel[nextIndex] = nextAlphabet;
            else if (wheel[nextIndex] != nextAlphabet) {
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        // 모든 회전이 끝난 후 바퀴에 적힌 글자가 모두 다른지 확인하는 배열
        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') continue;
            if (used[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            used[wheel[i] - 'A'] = true;
        }

        // 마지막 회전에서 화살표가 가리키는 문자부터 시계방향으로 바퀴에 적어놓은 알파벳을 출력
        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(curIndex + i) % N]);
        }
    }
}