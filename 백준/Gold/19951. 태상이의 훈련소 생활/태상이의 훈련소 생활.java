// https://www.acmicpc.net/problem/19951
// 문제: 일렬의 N칸으로 이루어진 연병장에 M번의 지시에 따라 [$a_m$ : $b_m$]칸의 높이를 k 만큼 바꿀 때, 모든 지시 수행 후 연병장 각 칸의 높이
// 시간복잡도 : O(N + M)
// 아이디어
// 1. 각 지시에 따른 변화량 delta를 기록한다.
// 2. 각 칸부터의 변화량을 각 칸에 적용한다.
// 3. 변화량이 적용된 각 칸의 높이를 출력한다.
// 자료구조 : 배열


import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 연병장 크기
        int M = sc.nextInt(); // 지시의 수
        int[] origin = new int[N + 1]; // 원본 배열
        for(int i = 1; i <= N; i++)
            origin[i] = sc.nextInt(); // 각 칸의 현재 높이

        // a와 b+1 칸으로 구성할 것이므로 크기를 N+2로 설정한다.
        int[] delta = new int[N + 2];
        while (M-- > 0) {
            // a~b 범위에 k를 + 또는 -
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            // 1. 각 지시에 따른 변화량 delta를 기록한다.
            //    delta[i]: [i:N] 까지 적용되는 변화량
            delta[a] += k;
            delta[b+1] -= k;
        }

        // 2. 각 칸부터의 변화량을 각 칸에 적용한다.
        int[] accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++)
            accDelta[i] = accDelta[i - 1] + delta[i];

        // 3. 변화량이 적용된 각 칸의 높이를 출력한다.
        for (int i = 1; i <= N; i++)
            System.out.print(origin[i] + accDelta[i] + " ");

        System.out.println();
    }
}