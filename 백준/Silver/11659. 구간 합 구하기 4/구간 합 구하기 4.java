// https://www.acmicpc.net/problem/11659
// 수 N개가 주어졌을 때, M번의 (i, j) 질문에 대해 i번째 수부터 j번째 수까지 합을 구하는 문제
// 시간복잡도 : O(N+M)
// 아이디어
// 1. 주어진 수를 배열에 담는다.
// 2. 누적합을 담을 배열을 만든다.
// 3. 구간 합을 누적합 배열을 이용해 계산한다.
// 자료구조 : 배열


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 주어진 수를 담을 배열
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        // 누적합 배열
        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++)
            acc[i] = acc[i - 1] + arr[i];

        // 구간합 계산
        while (M-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(acc[j] - acc[i - 1]);
        }
    }
}