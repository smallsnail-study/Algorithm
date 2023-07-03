import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 층 수
            int W = Integer.parseInt(st.nextToken()); // 방 수
            int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지
            int YY = (N - 1) % H + 1; // 층수
            int XX = (N - 1) / H + 1; // 엘리베이터로부터의 거리

            System.out.printf("%d%02d\n", YY, XX);
        }
    }
}