class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); // 우선순위가 높은 원소는 map.get(b) 값이 더 큰 값이고, 우선순위가 낮은 원소는 map.get(a) 값이 더 큰 값

        StringBuilder sb = new StringBuilder();

        q.addAll(map.keySet());

        while (!q.isEmpty()) {
            char c = q.poll();
            for (int i = 0; i < map.get(c); i++) { // key값에 해당하는 value만큼 key값을 추가
                sb.append(c);
            }
        }

        return sb.toString();
    }
}