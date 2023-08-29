// https://www.acmicpc.net/problem/16713
// 길이가 N인 수열이 주어질 때 Q개의 쿼리 (s, e)에 대해 s번째 원소부터 e번 원소까지 XOR한 값을 구하라
// 시간복잡도 : O(N+Q)
// 아이디어
// 1. 주어진 수를 배열에 담는다.
// 2. 누적 XOR 배열을 구한다.
// 3. Q번의 [s:e] 질문에 대해 누적XOR 배열을 사용해 구간 XOR을 구한다.
// 자료구조 : 배열


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. 누적 XOR 배열을 구한다.
        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }

        // 2. Q번의 [s:e] 질문에 대해 누적XOR 배열을 사용해 구간 XOR을 구한다.
        int ans = 0;
        while (Q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            ans ^= acc[e] ^ acc[s - 1];
        }
        System.out.println(ans);
    }
}