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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int root=start;root<=end;root++) {

            List<TreeNode> lefts = generateTrees(start, root-1);
            List<TreeNode> rights = generateTrees(root+1, end);

            for (TreeNode left:lefts) {
                for (TreeNode right:rights) {
                    TreeNode cur = new TreeNode(root);
                    cur.left = left;
                    cur.right = right;
                    ans.add(cur);
                }
            }
        }

        return ans;
    }
}