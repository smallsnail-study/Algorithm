import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder ans = new StringBuilder();
        while (N > 0) {
            int A = N % B;
            if (A < 10) ans.append(A);
            else ans.append((char) (A - 10 + 'A'));
            N = N / B;
        }
        for (int i = ans.length() - 1; i >= 0 ; i--) {
            bw.write(ans.charAt(i));
        }
        bw.flush();
    }
}