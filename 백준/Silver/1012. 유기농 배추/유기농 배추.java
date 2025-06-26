import java.util.*;
import java.io.*;

class Main {
    static int M, N, K;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            matrix = new int[N][M];
            // 배추위치(x, y) -> matrix[y][x]에 1로 표기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1;
            }
            
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    
    private static void bfs(int row, int col) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{row, col});
        matrix[row][col] = -1; // 방문처리
        
        // 상하좌우 4방향
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int r = cur[0];
            int c = cur[1];
            
            // 인접한 4방향 방문처리
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && matrix[nr][nc] == 1) {
                    matrix[nr][nc] = -1; // 방문표시
                    q.addLast(new int[]{nr, nc});
                }
            }
        }
    }
}