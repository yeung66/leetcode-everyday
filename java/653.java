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
    public boolean findTarget(TreeNode root, int k) {
        cnt = new HashSet<>();
        find = false;
        target = k;
        visit(root);
        return find;
    }

    public void visit(TreeNode node) {
        if (find || node == null) return;
        if (cnt.contains(node.val)) {
            // System.out.println(node.val);
            find = true;
            return;
        }

        // System.out.println(node.val);
        // System.out.println(target - node.val);

        cnt.add(target - node.val);
        visit(node.left);
        visit(node.right);
    }

    Set<Integer> cnt;
    boolean find;
    int target;
}