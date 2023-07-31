// https://leetcode.com/problems/root-equals-sum-of-children/
// 이진 트리의 루트가 제공될 때, 루트 값이 두 자식 값의 합과 같으면 true를 반환하고 그렇지 않으면 false를 반환
// 시간복잡도 : O(N)
// 아이디어 : 이진 트리를 재귀탐색, 각 노드의 값을 가져와서 왼쪽 자식 노드의 값과 오른쪽 자식 노드의 값을 더한 뒤, 현재 노드의 값과 비교
//만약 루트 노드부터 리프 노드까지의 모든 노드가 해당 조건을 만족한다면, true를 반환합니다. 그렇지 않으면 false를 반환합니다.
// 자료구조 : Binary Tree

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
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}