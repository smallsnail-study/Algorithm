import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(cards.contains(num) ? "1 " : "0 ");
        }

        br.close();
        System.out.println(sb.toString().trim());
    }
}