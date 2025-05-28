import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            switch (cmd) {
                case "push_front":
                    int numFront = Integer.parseInt(st.nextToken());
                    deque.offerFirst(numFront);
                    break;

                case "push_back":
                    int numBack = Integer.parseInt(st.nextToken());
                    deque.offerLast(numBack);
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;

                case "size":
                    bw.write(deque.size() + "\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;

                case "back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}