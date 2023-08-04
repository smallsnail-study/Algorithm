class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++)
            q.offer(nums[i]);
        
        return (q.poll()- 1) * (q.poll() - 1);
    }
}