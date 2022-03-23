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
        ans = -10001;
        maxGain(root);
        return ans;
        
    }

    int ans;

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        int pathSum = left + right + node.val;
        ans = Math.max(ans, pathSum);

        return node.val + Math.max(left, right);
    }

}