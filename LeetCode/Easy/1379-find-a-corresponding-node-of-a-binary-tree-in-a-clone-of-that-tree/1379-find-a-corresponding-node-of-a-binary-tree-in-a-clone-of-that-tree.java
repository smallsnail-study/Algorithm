// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
// 복제된 트리에서 원본과 동일한 노드에 대한 참조를 반환합니다.
// 시간복잡도 : O(N)
// 아이디어 : original 트리와 cloned 트리를 동시에 재귀탐색
//원본 트리에서 target 노드를 찾으면, 그에 해당하는 cloned 트리의 노드를 반환
//재귀 호출을 통해 original 트리를 탐색하면서, 동일한 경로로 cloned 트리를 탐색
//자식 노드를 탐색한 후 부모 노드로 다시 돌아오면서 탐색
// 자료구조 : Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if (original == target) return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (left != null) return left;
        return right;
    }
}