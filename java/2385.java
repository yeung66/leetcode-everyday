import java.util.*;

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

    Map<Integer, TreeNode> parent;
    Set<Integer> infected;

    TreeNode startNode;
    int start;
    public int amountOfTime(TreeNode root, int start) {
        parent = new HashMap<>();
        this.start = start;
        fillParent(root);

        infected = new HashSet<>();
        Queue<TreeNode> spread = new LinkedList<>();
        spread.add(startNode);
        infected.add(start);
        int times = -1;
        while (!spread.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            while (!spread.isEmpty()) {
                TreeNode cur = spread.poll();
                TreeNode parentNode = parent.get(cur.val);
                if (parentNode != null && !infected.contains(parentNode.val)) {
                    infected.add(parentNode.val);
                    next.add(parentNode);
                }

                if (cur.left != null && !infected.contains(cur.left.val)) {
                    infected.add(cur.left.val);
                    next.add(cur.left);
                }

                if (cur.right != null && !infected.contains(cur.right.val)) {
                    infected.add(cur.right.val);
                    next.add(cur.right);
                }
            }

            spread = next;
            times++;
        }

        return times;
    }

    public void fillParent(TreeNode node) {
        if (node.val == start) startNode = node;
        if (node.left != null) {
            parent.put(node.left.val, node);
            fillParent(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            fillParent(node.right);
        }
    }
}