import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command = br.ready() ? br.readLine() : "";

        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];
        int curR = 0, curC = 0;
        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = true;
                passVertical[curR-1][curC] = true;
                curR--;
            } else if (cmd == 'D') {
                if (curR== N-1) continue;
                passVertical[curR][curC] = true;
                passVertical[curR+1][curC] = true;
                curR++;
            } else if (cmd == 'L') {
                if (curC == 0) continue;
                passHorizontal[curR][curC] = true;
                passHorizontal[curR][curC - 1] = true;
                curC--;
            } else { // cmd == 'R'
                if (curC == N-1) continue;
                passHorizontal[curR][curC] = true;
                passHorizontal[curR][curC+1] = true;
                curC++;
            }
        }
        // 지나지않은 점은 '.' 표기
        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if (passVertical[i][j] && passHorizontal[i][j]) ans += "+";
                else if (passVertical[i][j]) ans += "|";
                else if (passHorizontal[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }
    }
}