/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        // System.out.println(root.val);
        // if (root.left == null && root.right == null) {
        //     root.left = root;
        //     root.right = root;
        //     return root;
        // }

        Node left = root.left, right = root.right;
        Node ans = root;
        root.left = root;
        root.right = root;

        if (left != null) {
            left = treeToDoublyList(left);
            ans = append(left, root);
        }
        
        if (right != null) {
            right = treeToDoublyList(right);
            ans = append(ans, right);
        }

        return ans;
        
    }

    public Node append(Node i1, Node i2) {
        Node i1last = i1.left;
        Node i2last = i2.left;

        i1.left = i2last;
        i2last.right = i1;
        i1last.right = i2;
        i2.left = i1last;
        return i1;
    }
}