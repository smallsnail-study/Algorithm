import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command = br.ready() ? br.readLine() : "";

        // 로봇 팔의 이동여부를 확인할 boolean 배열
        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];
        // 처음 로봇의 조각도를 올려놓는 위치는 항상 맨 왼쪽, 맨 위(0,0)
        int curR = 0, curC = 0;
        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = true;
                passVertical[curR-1][curC] = true;
                curR--;
            } else if (cmd == 'D') {
                if (curR == N-1) continue;
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

// 시간복잡도 : O(max(N^2,L))
// 아이디어 :
// 1.명령어의 최소길이가 정해지지 않은 경우 빈 문자열이 주어질 수 있으므로 주의하자! RuntimeError 발생 가능
// 2. 구하려는 값을 확인해서 답으로 만드는 경우 -> boolean 배열 활용
// 자료구조 : 시뮬레이션