import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String ps = br.readLine();
            System.out.println(isVPS(ps));
        }
    }

    private static String isVPS(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push('(');
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    return "NO";
                }
                st.pop();
            }
        }

        return st.isEmpty() ? "YES" : "NO";
    }
}