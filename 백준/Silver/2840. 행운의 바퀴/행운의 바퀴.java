import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        int curIndex = 0;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char nextAlphabet = st.nextToken().charAt(0);

            int nextIndex = ((curIndex - S) % N + N) % N;
            if (wheel[nextIndex] == '?') wheel[nextIndex] = nextAlphabet;
            else if (wheel[nextIndex] != nextAlphabet) {
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') continue;
            else if (used[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            used[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(curIndex + i) % N]);
        }
    }
}

// 시간복잡도 : O(N + K), O(max(N, K))
// 아이디어 :
// Arrays.fill() : 배열 전체를 특정 값으로 채우는 형태 또는 배열의 일부분을 특정 값으로 채우는 형태
// char 배열 wheel: 바퀴의 각 칸을 저장하는 배열로, 바퀴의 상태를 나타냅니다.
//boolean 배열 used: 알파벳의 사용 여부를 나타내는 배열로, 중복된 알파벳을 확인하는 데 사용됩니다.
// 자료구조 : 시뮬레이션