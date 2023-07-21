import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {   // O(N+M)
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    // A가 B보다 큰 쌍의 개수
    static int lower_bound(int[] A, int L, int R, int X) {  // O(logM)
        // L : 탐색할 가치가 있는 범위의 왼쪽 끝 인덱스
        // R : 탐색할 가치가 있는 범위의 오른쪽 끝 인덱스
        // A[L..R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // A[L..R] 에서 X 미만의 수가 없다면 L - 1 을 return

        // res : X 미만의 수 중 제일 오른쪽 인덱스
        int res = L - 1; // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;  // 범위를 "이분" 한다.
            if (A[mid] < X) { // 중간값이 X보다 작은경우
                res = mid;
                L = mid + 1; // 범위를 mid보다 큰 수 범위로 변경한다.
            } else { // 중간값 mid가 X보다 크거나 같다면 X미만 수를 구하기 위해
                R = mid - 1;    // 범위를 mid보다 작은 수 범위로 변경한다.
            }
        }
        return res;
    }

    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해준다.
        Arrays.sort(B, 1, M + 1);   // O(M logM)

        // ans : A[i]보다 작은 B[i]의 개수
        int ans = 0;
        for (int i = 1; i <= N; i++) {  // O(N logM)
            // A[i]를 선택했을 때, B에서는 A[i]보다 작은 수가 몇 개나 있는지 count하기
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextlong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

// 시간복잡도 : O((N + M) + M log M + N log M) => O((N + M) log M)
// 아이디어 : Arrays.sort()로 정렬한 다음 이분탐색 (X 미만의 원소 개수 구하기)
// 자료구조 : 배열