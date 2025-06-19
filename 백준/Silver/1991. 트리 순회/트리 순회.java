import java.util.*;
import java.io.*;

class Main {
    static Map<Character, char[]> tree = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.put(parent, new char[]{left, right});
        }
       
        StringBuilder sb = new StringBuilder();
        preorder('A', sb);
        sb.append("\n");
        inorder('A', sb);
        sb.append("\n");
        postorder('A', sb);
        sb.append("\n");
        System.out.println(sb.toString());
    }
    
    private static void preorder(char center, StringBuilder sb) {
        if (center == '.')
            return;
        sb.append(center);
        char[] children = tree.get(center);
        preorder(children[0], sb);
        preorder(children[1], sb);
    }
    
    private static void inorder(char center, StringBuilder sb) {
        if (center == '.')
            return;
        char[] children = tree.get(center);
        inorder(children[0], sb);
        sb.append(center);
        inorder(children[1], sb);
    }
    
    private static void postorder(char center, StringBuilder sb) {
        if (center == '.')
            return;
        char[] children = tree.get(center);
        postorder(children[0], sb);
        postorder(children[1], sb);
        sb.append(center);
    }
}