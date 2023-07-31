// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// 요소가 오름차순으로 정렬된 정수 배열 nums가 주어지면 이를 높이 균형 이진 검색 트리로 변환
// 시간복잡도 : O(nlogn)
// 아이디어 : 배열이 정렬되어 있으므로 중간 수를 root로 설정, root 기준 왼쪽 서브배열, 오른쪽 서브배열로 나누고 반복
// 자료구조 : Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return ArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode ArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ArrayToBST(nums, left, mid - 1);
        root.right = ArrayToBST(nums, mid + 1, right);
        return root;
    }
}