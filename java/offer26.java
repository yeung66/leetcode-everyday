/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;

        if (A.val == B.val) {
            if (contain(A, B))
                return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean contain(TreeNode A, TreeNode B) {
        boolean ans = true;
        if (B.left != null) {
            if (A.left != null && A.left.val == B.left.val) {
                ans = ans && contain(A.left, B.left);
            } else {
                return false;
            }
        }
        
        if (B.right != null) {
            if (A.right != null && A.right.val == B.right.val) {
                ans = ans && contain(A.right, B.right);
            } else {
                return false;
            }
        }
        
        return ans;
    }
}