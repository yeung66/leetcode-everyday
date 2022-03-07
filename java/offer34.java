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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        if (root == null) return ans;

        dfs(root, new ArrayList<>(), target);
        return ans;
    }

    List<List<Integer>> ans;
    
    public void dfs(TreeNode node, List<Integer> path, int target) {
        // System.out.printf("%d %d\n", node.val, target);
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                path.add(node.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }

        path.add(node.val);
        if (node.left != null) {
            dfs(node.left, path, target - node.val);
            
        }

        if (node.right != null) {
            dfs(node.right, path, target - node.val);
        }

        path.remove(path.size()-1);
    }
}