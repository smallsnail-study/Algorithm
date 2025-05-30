import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> nums = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(nums.contains(num) ? 1 : 0);
        }
        br.close();
    }
}