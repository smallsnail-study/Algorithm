import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        
        for (int y = 0; y < N; y++) {
            char[] line = br.readLine().toCharArray();
            for (int x = 0; x < N; x++) {
                matrix[y][x] = line[x] - '0';
            }
        }
        br.close();
        
        visited = new boolean[N][N];
        List<Integer> answers = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (matrix[y][x] == 1 && !visited[y][x]) {
                    answers.add(bfs(y, x));
                }
            }
        }
        
        Collections.sort(answers);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answers.size() + "\n");
        for(int size : answers) {
            bw.write(size + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static int bfs(int y, int x) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int count = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (!visited[ny][nx] && matrix[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}