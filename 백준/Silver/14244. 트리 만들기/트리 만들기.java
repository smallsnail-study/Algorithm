import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 리프 노드 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m ;i++) {
            sb.append(0).append(" ").append(i + 1).append("\n");
        }
        for (int i = m; i < n-1; i++) {
            sb.append(i).append(" ").append(i+1).append("\n");
        }
        System.out.print(sb);
    }
}