import java.util.Arrays;
import java.util.Scanner;

class Main {
    static boolean isExist(String[] S, String str) {
        int left = 0, right = S.length -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int result = S[mid].compareTo(str); // compareTo 문자열 비교(같으면 0반환,다르면 다른문자 개수 반환)
            if (result == 0) return true;
            else if (result < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.next();
        }

        Arrays.sort(S);

        int ans = 0;
        while (M-- > 0) {
            String str = sc.next();
            if (isExist(S, str))
                ans++;
        }
        System.out.println(ans);
    }
}