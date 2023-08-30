// https://www.acmicpc.net/problem/11660
// 문제: NxN 표가 주어질 때 M개의 쿼리 (x1, y1, x2, y2)에 대해 (x1, y1)부터 (x2, y2)까지의 합을 구하라
// 시간복잡도 : O(N^2 + M)
// 아이디어
// 1. 주어진 수를 배열에 담는다.
// 2. 누적합 배열을 구한다.
// 2-1. 필요한 누적합 참조
// 2-2. 중복해서 가져온 누적합 부분을 빼준다.
// 2-3. 현재 부분의 원소를 더한다.
// 3. 누적합 배열을 사용해 구간합을 구한다.
// 3-1. 필요한 값이 모두 들어있는 누적합을 참조한다. (x2, y2)
// 3-2. 불필요한 값이 들어있는 누적합을 빼준다. (x1-1, y2) (x2, y1-1)
// 3-3. 중복해서 제외된 값을 다시 더해준다. (x1-1, y1-1)
// 자료구조 : 2차원배열


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                arr[i][j] = sc.nextInt();

        // 1. 누적합 배열을 구한다.
        int[][] acc = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++){
                // 1. 필요한 누적합 참조
                // 2. 중복해서 가져온 누적합을 빼준다.
                // 3. 지금 부분의 원소를 더한다.
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            }

        // 출력해야 하는 범위인 M의 최대값이 100,000 이므로 BufferedWriter를 사용해야 한다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (M-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 2. 누적합 배열을 사용해 구간합을 구한다.
            // 2-1. 필요한 값이 모두 들어있는 누적합을 참조한다. (x2, y2)
            // 2-2. 불필요한 값이 들어있는 누적합을 빼준다. (x1-1, y2) (x2, y1-1)
            // 2-3. 중복해서 제외된 값을 다시 더해준다. (x1-1, y1-1)
            bw.write(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();
    }
}