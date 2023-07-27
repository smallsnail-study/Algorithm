
// 시간복잡도 : O(N)
// 아이디어
// 1. 인접리스트로 자식노,부모노드들 저장
// 2. 지울 노드를 찾아서 부모와 연결을 끊고, 트리에서 제거
// 3. 지울 노드가 루트가 아니면, DFS로 지울 노드를 루트로 하는 서브트리의 leaf 노드 개수를 구한다.
// 4. 루트 노드가 지울 노드라면, 빈 트리가 되므로 0
// 자료구조 : Tree, ArrayList

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, root, erased; // n(노드개수),erased(지울노드번호)
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        n = scan.nextInt(); // 정점의 개수
        child = new ArrayList[n];
        leaf = new int[n];
        for (int i=0;i<n;i++) child[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int par = scan.nextInt(); // 주어진 각 노드의 부모
            if (par == -1) { // parent가 -1이면 root
                root = i;
                continue;
            }
            // parent가 -1이 아니면 parent의 자식 중에 i가 있는걸 아니까
            // child의 parent 위치에 i를 추가해준다.
            child[par].add(i);
        }
        erased = scan.nextInt();
    }

    // dfs(x, par) := 정점 x의 부모가 par였고, Subtree(X)의 leaf 개수를 세주는 함수
    static void dfs(int x) {
        // child[x]의 값이 없다면, 자식 노드가 없으므로
        if (child[x].isEmpty()) {
            leaf[x] = 1;
        }

        // x의 자식들을 하나씩 보면서 누적해준다.
        for (int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }


    static void pro() {
        // erased와 그의 부모 사이의 연결을 끊어주기
        // 지워질 노드를 찾고 그 노드의 부모를 찾는다.
        // 즉, 자식 중에 erased를 찾아서 자식 중에 erased를 지워버린다.
        for (int i = 0; i < n; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }
        // 예외처리 : 만약 root가 삭제됐다면, 위의 for문을 적용할 수 없다.
        // 빈 그래프가 되어서 leaf 노드 값이 0이 되어야 한다.
        if (root != erased) dfs(root);

        // 정답 출력하기 -> leaf의 root 노드에 있는 값을 출력
        System.out.println(leaf[root]);
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