// https://www.acmicpc.net/problem/17232
// 문제: NxM 바둑판에서 1시간마다 각 칸을 중심으로 주위 (2K+1)*(2K+1) 생명에 따라 아래 상황이 발생할때, T시간 뒤 생명현황
//1. 생존: 현재 칸에 생명이 있고, a ≤ 주위생명 ≤ b 라면 해당 칸의 생명은 생존한다.
//2. 고독: 현재 칸에 생명이 있고, 주위생명 < a 라면 해당 칸의 생명은 외로워서 죽는다.
//3. 과밀: 현재 칸에 생명이 있고, b < 주위생명 라면 해당 칸의 생명은 과밀로 죽는다.
//4. 탄생: 현재 칸에 생명이 없고, a < 주위생명 ≤ b 라면 해당 칸에 생명이 생긴다.
// 시간복잡도 : O(T * N * M)
// 아이디어
// 1. 입력을 char[][]로 받는다.
// 2. T번의 시간동안 각 시간에 알맞은 누적합을 구한다.
// 3. 각 시간에 알맞은 누적합을 구한다.
// 4. 각각의 칸에 생명이 주변 생명에 따라 생존,사망,탄생하는지 확인
// 5. T 시간 뒤 map에 남아있는 생명들 출력
// 자료구조 : 2차원 배열


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 입력을 받는다.
        char[][] map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String rowMap = sc.next();
            for (int j = 1; j <= M; j++)
                map[i][j] = rowMap.charAt(j - 1);
        }

        // T시간동안 각 칸은 시간마다 아래 상황을 반복한다.
        // 1. 생존: 현재 칸에 생명이 있고, a ≤ 주위생명 ≤ b 라면 해당 칸의 생명은 생존한다.
        //2. 고독: 현재 칸에 생명이 있고, 주위생명 < a 라면 해당 칸의 생명은 외로워서 죽는다.
        //3. 과밀: 현재 칸에 생명이 있고, b < 주위생명 라면 해당 칸의 생명은 과밀로 죽는다.
        //4. 탄생: 현재 칸에 생명이 없고, a < 주위생명 ≤ b 라면 해당 칸에 생명이 생긴다.
        while (T-- > 0) { // T번의 시간동안 각 시간에 알맞은 누적합을 구한다.
            // 각 시간에 알맞은 누적합을 구한다.
            // 지금 시간의 누적합으로 다음시간의 map을 구해준다.
            int[][] acc = getPrefixSum(map);

            // 각각의 칸에 생명이 주변 생명에 따라 생존,사망,탄생하는지 확인
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // (i,j) 주변에 생명이 몇개가 있는지
                    // 누적합을 구해두고 누적합에서 (i,j)기준으로 상하좌우로 K에 있는 생명이 몇개나 되는지
                    int nearAlive = getRangeSum(acc, i, j, K);
                    // 각 칸에서 다음번 (i,j)에 생명이 있을지 없을지 결정
                    if (map[i][j] == '*') { // 현재 생명이 있는경우
                        // 1,2,3 번 조건
                        nearAlive--;
                        if (nearAlive < A || B < nearAlive) // 고독or과밀
                            map[i][j] = '.';
                    }
                    else if(A < nearAlive && nearAlive <= B) // 4번조건
                        map[i][j] = '*';
                }
            }
        }

        // T 시간 뒤 map에 남아있는 생명들 출력
        // 현재 map의 상태 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++)
                System.out.print(map[i][j]);

            System.out.println();
        }
    }

    static int[][] getPrefixSum(char[][] map) {// 입력 : 현재 상태의 map
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++)
            for (int j = 1; j < map[0].length; j++)
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + (map[i][j]=='*'? 1 : 0);

        return acc;
    }

    // (i,j)를 중심으로 K의 칸에 대해 살아있는 생명의 숫자
    static int getRangeSum(int[][] acc, int r, int c, int K) {
        // 인덱스(범위 확인 필요)
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1);
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }
}