// https://leetcode.com/problems/sort-characters-by-frequency/
// 문자열 s가 주어지면 문자 빈도에 따라 내림차순으로 정렬, 문자의 빈도는 문자열에 나타나는 횟수
// 시간복잡도 : O(NlogK) K는 중복되지 않은 문자 개수
// 아이디어
// 1. Map에 문자,빈도수를 저장
// 2. 빈도 수 기준으로 우선순위 큐에 추가
// 3. 빈도 수 만큼 문자를 추가
// 자료구조 : 우선순위 큐(PriorityQueue), Map

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) // O(N)
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); // 우선순위가 높은 원소는 map.get(b) 값이 더 큰 값이고, 우선순위가 낮은 원소는 map.get(a) 값이 더 큰 값

        StringBuilder sb = new StringBuilder();

        q.addAll(map.keySet()); // O(KlogK)

        while (!q.isEmpty()) {
            char c = q.poll();
            for (int i = 0; i < map.get(c); i++) { // key값에 해당하는 value만큼 key값을 추가
                sb.append(c); // O(NlogK)
            }
        }

        return sb.toString();
    }
}