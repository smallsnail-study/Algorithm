import java.io.*;

class Main {
    public static int[] convertBase(int A, int B) {
        int len = 0, copyA = A;
        while (copyA > 0) {
            copyA = copyA / B;
            len++;
        }
        int[] digit = new int[len];
        len = 0;
        while (A > 0) {
            digit[len++] = A % B;
            A = A / B;
        }
        return digit;
    }

    public static boolean isPalindrome(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            if (digit[i] != digit[digit.length - i - 1]) {
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
            int A = Integer.parseInt(br.readLine());
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                int[] digit = convertBase(A, i);
                if (isPalindrome(digit)) ans = true;
            }
            bw.write(ans ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
    }
}