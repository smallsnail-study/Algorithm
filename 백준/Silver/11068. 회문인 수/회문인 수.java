import java.io.*;

class Main {
    public static int[] convertBase(int K, int B) {
        // 주어진 수 K를 B진법으로 변환후 담을 배열의 크기를 구한다. K / B 의 크기
        int len = 0, copyK = K;
        while (copyK > 0) {
            copyK = copyK / B;
            len++;
        }

        // 주어진 수 K를 B진법으로 변환해서 배열 convert에 담는다.
        int[] convert = new int[len];
        len = 0;
        for (int i = 0; i < convert.length; i++) {
            convert[len++] = K % B;
            K = K / B;
        }
        return convert;
    }

    public static boolean isPalindrome(int[] convert) {
        for (int i = 0; i < convert.length / 2; i++) {
            if (convert[i] != convert[convert.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                int[] convertNum = convertBase(K, i);
                if (isPalindrome(convertNum)){
                    ans = true;
                    break;
                }
            }
            bw.write(ans ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
    }
}