import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0)
                System.out.println(q.size() == 0 ? 0 : q.poll());
            else q.add(x);
        }
    }
}