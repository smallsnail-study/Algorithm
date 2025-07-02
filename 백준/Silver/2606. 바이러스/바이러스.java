import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(count);
    }
    
    private static void dfs(int cur) { 
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}