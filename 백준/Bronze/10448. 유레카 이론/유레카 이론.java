import java.io.*;

class Main {
    static boolean[] isSumOfTriangleNumber = new boolean[1001];
    public static void preprocess() {
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i +1) / 2;
            if (triangleNumber >= 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
//        boolean[] isSumOfTriangleNumber = new boolean[1000];

        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                for (int k = 0; k < triangleNumberCount; k++) {
                    int sum = triangleNumbers[i] + triangleNumbers[j]+triangleNumbers[k];
                    if (sum <= 1000) isSumOfTriangleNumber[sum] = true;
                }
            }
        }
    }

//    static boolean isEurekaNumber = new boolean[1001];

    public static void main(String[] args) throws IOException {
        preprocess();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            bw.write(isSumOfTriangleNumber[K] ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
    }
}