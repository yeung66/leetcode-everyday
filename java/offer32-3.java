import java.util.*;


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        boolean dir = false;

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            
            if (dir) {
                Collections.reverse(curLevel);
            }

            ans.add(curLevel);
            dir = !dir;
        }

        return ans;
    }
}