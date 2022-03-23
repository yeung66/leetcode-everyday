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
    public int maxPathSum(TreeNode root) {
        if (root == null) return -10000;
        int solu1 = Math.max(0, maxSubPath(root.left)) + Math.max(0, maxSubPath(root.right)) + root.val;
        return Math.max(Math.max(maxPathSum(root.left), maxPathSum(root.right)), solu1);
        
    }

    public int maxSubPath(TreeNode node) {
        if (node == null) return 0;

        int left = maxSubPath(node.left);
        int right = maxSubPath(node.right);
        return Math.max(Math.max(left, right), 0) + node.val;
    }
}