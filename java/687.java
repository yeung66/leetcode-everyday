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
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
        
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int path = 0;
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        int newLeftPath = 0, newRightPath = 0;
        if (node.left != null && node.val == node.left.val) {newLeftPath = leftPath + 1; path = leftPath + 1;}
        if (node.right != null && node.val == node.right.val) {newRightPath = rightPath + 1; path += rightPath + 1;}
        ans = Math.max(ans, path);

        return Math.max(newLeftPath, newRightPath);
    }
}