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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }

        // if (root.right != null)
        root.right = insertIntoMaxTree(root.right, val);
        // else
        //     root.right = new TreeNode(val);
        return root;
    }
}