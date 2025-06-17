import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 1; i <= N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        br.close();
        
        parents = new int[N+1];
        traverse(1, 0);
            
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i < N+1; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void traverse(int cur, int parent) {
        parents[cur] = parent;
        
        for (int next : tree.get(cur)) {
            if (next == parent) {
                continue;
            }
            
            traverse(next, cur);
        }
    }
}