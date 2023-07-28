import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n; // 이진트리 노드 개수
    static int[][] childs; // 이진트리

    static void input() {
        n = scan.nextInt();
        childs = new int[26][2];
        for (int i = 0; i < n; i++) {
            char par = scan.next().charAt(0);
            int parNum = (int) (par - 'A'); // 부모노드의 문자를 숫자로 변환
            for (int j = 0; j < 2; j++) { // 이진트리라 자식노드는 최대 2개
                char ch = scan.next().charAt(0);
                if (ch == '.') childs[parNum][j] = -1;
                else childs[parNum][j] = (int) (ch - 'A');
            }
        }
    }

    // x가 Root, [x][0]이 Left, [x][1]이 Right
    static void pre_order(int x) { // 전위순회(r>L>R)
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    static void in_order(int x) { // 중위순회(L>r>R)
        if (x == -1) return;
        in_order(childs[x][0]);
        sb.append((char) (x + 'A'));
        in_order(childs[x][1]);
    }

    static void post_order(int x) { // 후위순회(L>R>r)
        if (x == -1) return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        sb.append((char) (x + 'A'));
    }

    // 전위 순회, 중위 순회, 후위 순회를 줄바꿈으로 출력
    static void pro() {
        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);

        System.out.print(sb);
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

        long nextLong() {
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