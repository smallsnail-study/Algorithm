class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}

// 시간복잡도 : O(n)
// 아이디어 : 0~n 수의 합을 구하고 합에서 원소 빼주기
// 자료구조 : 배열