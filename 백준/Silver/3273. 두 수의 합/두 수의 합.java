import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[1000000];
        for (int i = 0; i < n; i++) {
            exist[a[i]] = true;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int pairValue = x - a[i];
            if (1<= pairValue && pairValue <= 1000000)
                ans += exist[pairValue]?1:0;
        }
        System.out.println(ans / 2);
    }
}