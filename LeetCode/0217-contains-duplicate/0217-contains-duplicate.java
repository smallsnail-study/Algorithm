import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        for (int i = sortedArr.length-1; i >= 1; i--) {
            if (sortedArr[i] == sortedArr[i-1]) return true;
        }
        return false;
    }
}