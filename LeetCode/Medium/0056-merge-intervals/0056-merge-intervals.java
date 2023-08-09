// https://leetcode.com/problems/merge-intervals/
// intervals[i] = [starti, endi]인 간격 배열이 주어지면 모든 겹치는 간격을 병합하고 입력의 모든 간격을 포함하는 겹치지 않는 간격의 배열을 반환합니다.
// 시간복잡도 : O(NlogN)
// 아이디어 : 시작값 기준으로 정렬해서 비교
// 자료구조 : 배열

class Solution {
    public int[][] merge(int[][] intervals) {

				// 첫번째 배열 요소를 기준으로 오름차순 정렬(각 구간 시작 값 기준으로 정렬)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 정렬한 구간들을 ArrayList로 담는다.
				List<int[]> ans = new ArrayList<>();
        
        for (int[] interval : intervals) {
						// ArrayList가 비어있거나 현재구간 시작값이 리스트 마지막구간 끝값보다 큰 경우
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else { // 현재구간과 이전 구간이 겹치는 경우, 현재구간의 끝값과 리스트 마지막구간값 비교
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}