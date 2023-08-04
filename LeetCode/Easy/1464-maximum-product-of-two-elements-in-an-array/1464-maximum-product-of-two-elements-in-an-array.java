class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++)
            q.offer(nums[i]);
        
        int i = q.poll();
        int j = q.poll();
        return (i - 1) * (j - 1);
    }
}