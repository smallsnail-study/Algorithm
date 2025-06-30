import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1]; 
        for (int i = 1; i < N + 1; i ++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        visited = new boolean[N + 1];
        dfs(V, sb);
        sb.append("\n");
        
        visited = new boolean[N + 1];
        bfs(V, sb);
        
        System.out.println(sb);
    }
    
    private static void dfs(int cur, StringBuilder sb) {
        visited[cur] = true;
        sb.append(cur).append(' ');
        for (int next : graph[cur]) {
            if (!visited[next])
                dfs(next, sb);
        }
    }
    
    private static void bfs(int start, StringBuilder sb) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}