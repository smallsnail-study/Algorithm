// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
// 정수 배열 선물이 주어진다.
//1초마다 다음을 수행합니다.
//최대 선물 수가 있는 더미를 선택합니다.
//최대 선물 수가 있는 더미가 두 개 이상인 경우 아무거나 선택합니다.
//더미에 있는 선물 수의 제곱근 바닥 뒤에 둡니다. 나머지 선물을 가져가세요.
//k 초 후에 남은 선물의 수를 반환합니다.
// 시간복잡도 : O((N+k)logN)
// 아이디어
// 1. 주어진 수를 우선순위 큐에 넣는다.
// 2. 우선순위 큐에서 가장 큰값을 꺼내고, 제곱근을 구해서 다시 큐에 삽입한다.
// 3. 큐의 합계를 구한다.
// 자료구조 : 우선순위 큐(PriorityQueue)

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < gifts.length; i++)
            q.add(gifts[i]); // 내림차순으로 queue에 담는다.

        while (k-- > 0) {
            // 가장 큰 수를 꺼내고 제곱근을 구해서 삽입한다.
            // Math.sqrt() 제곱근
            q.add((int) Math.sqrt(q.poll()));
        }

        // 주어진 수 합계 범위가 int를 초과한다.
        // gitfs[i] 최대값 10^9 , gifts.length 최대값 10^3
        long sum = 0;
        while (!q.isEmpty()) sum += q.poll();
        return sum;
    }
}