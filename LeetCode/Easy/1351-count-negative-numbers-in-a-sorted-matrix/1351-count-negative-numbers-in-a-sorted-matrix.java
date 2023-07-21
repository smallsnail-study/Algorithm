// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
// 시간복잡도 : O(NM)
// 아이디어 : 2차원배열의 열의 길이는 arr[i].length로 구하기
// 자료구조 : 2차원배열

class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0)
                    ans++;
            }
        }
        return ans;
    }
}