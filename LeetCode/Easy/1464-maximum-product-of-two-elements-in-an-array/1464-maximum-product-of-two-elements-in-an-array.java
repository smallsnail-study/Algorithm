// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
// 정수 배열이 주어지고 2개의 숫자를 선택해서 각각의 숫자에서 1을 뺸 값의 곱이 가장 큰 수를 구하시오
// 시간복잡도 : O(NlogN)
// 아이디어
// 1. 주어진 수를 우선순위 큐에 넣는다.
// 2. 우선순위 큐에서 가장 큰값을 꺼내고, 그 다음 큰 값을 꺼내서 각 숫자에서 1을 뺀 후 곱한다.
// 주의 : 배열의 길이가 2 이상이어야 한다.그렇지 않으면 런타임 에러가 발생할 수 있습니다. 따라서, 배열 길이에 대한 예외 처리가 필요
// 자료구조 : 우선순위 큐(PriorityQueue)

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++)
            q.offer(nums[i]);

        return (q.poll()- 1) * (q.poll() - 1);
    }
}