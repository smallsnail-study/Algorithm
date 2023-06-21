import java.io.*;

class Main {
    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess() {
        int[] triangle = new int[50];
        int triangleCount = 0;
        for (int i = 1;  ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber > 1000) break;
            triangle[triangleCount++] = triangleNumber;
        }

        for (int i = 0; i < triangleCount; i++) {
            for (int j = 0; j < triangleCount; j++) {
                for (int k = 0; k < triangleCount; k++) {
                    int sum = triangle[i] + triangle[j] + triangle[k];
                    if (sum <= 1000) isEurekaNumber[sum] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        preprocess();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            bw.write(isEurekaNumber[K] ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
    }
}