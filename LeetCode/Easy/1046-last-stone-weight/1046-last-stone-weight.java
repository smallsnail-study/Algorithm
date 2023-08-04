// https://leetcode.com/problems/last-stone-weight/
// 1. 가장 큰 값 비교
// 2. 두 값이 같으면 둘 다 삭제
// 3. 다르면 작은 값 삭제, 큰값은 큰값-작은값으로 변경
// 4. 최소한 한개만 남음, 남은게 없으면 0반환
// 시간복잡도 : O(NlogN)
// 아이디어 : 두 돌을 비교하여 더 큰 돌에서 더 작은 돌을 뺀 값을 다시 큐에 추가
// 가장 큰 돌이 남을 때까지 반복,우선순위 큐를 사용하여 항상 가장 큰 돌이 맨 앞에 오도록 유지
// 자료구조 : PriorityQueue

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i < stones.length; i++)
            q.add(stones[i]);
        
        while(q.size() > 1){
            int x = q.poll();
            int y = q.poll();

            if(x > y) q.add(x-y);
            else if(x < y) q.add(y-x);
        }

        if(q.isEmpty()) return 0;
        else return q.peek();
    }
}