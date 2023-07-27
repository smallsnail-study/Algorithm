
// 시간복잡도 : O(N)
// 아이디어
// 1. DFS로 루트부터 각 노드의 부모 탐색
// 2. 인접리스트로 연결된 노드들 저장
// 3. 정점 X가 Parent를 안다면, 자신의 자식 Childeren을 찾을 수 있다.
// 4. Root부터 차례대로 탐색
// 자료구조 : Tree, ArrayList

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n; // 노드의 개수
    static ArrayList<Integer>[] adj; // 정점들을 인접리스트로 저장
    static int[] parent; // 출력할 부모 노드

    static void input() {
        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        // 인접 리스트 구성하기
        for (int i = 1; i < n; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // dfs(x, par) := 정점 x의 부모가 par였고, x의 childeren을 찾아주는 함수
    static void dfs(int x, int par) {
        for (int y : adj[x]) { // 정점 x와 연결된 노드들을 확인
            if (y == par) continue; // x와 연결된 y가 parent와 같다면 children이 아니니까 무시
            parent[y] = x; // y가 x의 자식인걸 아는 순간(= y의 부모가 x)
            dfs(y, x); // y의 부모는 x(par)
        }
    }


    static void pro() {
        // 1번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        dfs(1, -1); // Root의 부모는 없으니까 -1로 설정

        // 정답 출력하기
        // 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
        for (int i = 2; i <= n; i++)
            sb.append(parent[i]).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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
            while (st == null || !st.hasMoreTokens()) {
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

        long nextLong() {
            return Long.parseLong(next());
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