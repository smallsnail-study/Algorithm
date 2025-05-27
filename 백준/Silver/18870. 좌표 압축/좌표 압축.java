import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> uniqueArr = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            uniqueArr.add(arr[i]);
        }

        ArrayList<Integer> sortedUniqueArr = new ArrayList<>(uniqueArr);
        Collections.sort(sortedUniqueArr);

        HashMap<Integer,Integer> mapper = new HashMap<>();
        for (int i = 0; i < sortedUniqueArr.size(); i++) {
            mapper.put(sortedUniqueArr.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mapper.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}