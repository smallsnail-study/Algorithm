import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuffer ans = new StringBuffer();
        while (N > 0) {
            int R = N % B;
            if (R < 10) ans.append(R);
            else ans.append((char) (R - 10 + 'A'));
            N = N / B;
        }
        for (int i = ans.length() - 1; i >= 0; i--) {
            bw.write(ans.charAt(i));
        }
        bw.flush();
    }
}