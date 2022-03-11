/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean first = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (!first) {
                ans.append(',');
            } else {
                first = false;
            }

            if (node == null) {
                ans.append("null");
            } else {
                ans.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            
            
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] parts = data.split(",");
        int idx = 1, n = parts.length;
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (idx < n) {
            TreeNode node = queue.poll();
            if (!parts[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(parts[idx]));
                queue.add(node.left);
            }

            idx++;

            if (idx < n && !parts[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(parts[idx]));
                queue.add(node.right);
            }
            idx++;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));