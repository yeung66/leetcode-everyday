// https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
import java.util.ArrayList;

/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 * 
 * public TreeNode(int val) {
 * this.val = val;
 * 
 * }
 * 
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ans = new ArrayList<>();
        dfs(root, 0, expectNumber, new ArrayList<>());
        return ans;
    }

    ArrayList<ArrayList<Integer>> ans;

    public void dfs(TreeNode node, int prevSum, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        if (node.left == null && node.right == null && node.val + prevSum == target) {
            ArrayList<Integer> p = new ArrayList<>(path);
            ans.add(p);
        }

        if (node.left != null) {
            dfs(node.left, node.val + prevSum, target, path);
        }

        if (node.right != null) {
            dfs(node.right, node.val + prevSum, target, path);
        }

        path.remove(path.size() - 1);
    }
}