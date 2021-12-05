import java.util.*;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    class Step {
        public int cnt;
        public String path;
        public TreeNode cur;

        public Step(String path, TreeNode cur) {
            this.path = path;
            this.cur = cur;
            this.cnt = path.length();
        }
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        parent = new HashMap<>();
        dest = destValue;
        start = startValue;
        
        dfs(root, null);

        int n = parent.size();
        visited = new boolean[n + 1];

        Queue<Step> queue = new PriorityQueue<>((s1, s2) -> s1.cnt - s2.cnt);
        queue.add(new Step("", startNode));

        while (!queue.isEmpty()) {
            Step s = queue.poll();
            TreeNode node = s.cur;

            if (node.val == destValue)
                return s.path;

            visited[node.val] = true;

            if (node.left != null && !visited[node.left.val]) {
                queue.add(new Step(s.path + "L", node.left));
            }

            if (node.right != null && !visited[node.right.val]) {
                queue.add(new Step(s.path + "R", node.right));
            }

            TreeNode p = parent.get(node.val);
            if (p != null && !visited[p.val]) {
                queue.add(new Step(s.path + "U", p));
            }
        }

        // dfsPath(startNode, "");

        return ans;
    }

    public void dfsPath(TreeNode node, String prevPath) {
        if (node.val == dest) {
            ans = prevPath;
            return;
        }

        if (ans != null)
            return;

        System.out.printf("%d %s\n", node.val, prevPath);

        visited[node.val] = true;

        if (node.left != null && !visited[node.left.val]) {
            dfsPath(node.left, prevPath + "L");
        }

        if (node.right != null && !visited[node.right.val]) {
            dfsPath(node.right, prevPath + "R");
        }

        TreeNode p = parent.get(node.val);
        if (p != null && !visited[p.val]) {
            dfsPath(p, prevPath + "U");
        }
    }

    boolean[] visited;
    int dest;
    int start;
    String ans;
    TreeNode startNode;
    Map<Integer, TreeNode> parent;

    public void dfs(TreeNode node, TreeNode p) {
        if (node != null) {
            parent.put(node.val, p);
            dfs(node.left, node);
            dfs(node.right, node);

            if (node.val == start)
                startNode = node;
        }
    }
}