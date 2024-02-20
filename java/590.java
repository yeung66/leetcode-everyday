/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// class Solution {
//     public List<Integer> postorder(Node root) {
//         ans = new ArrayList<>();
//         visit(root);
//         return ans;
//     }

//     List<Integer> ans;

//     public void visit(Node node) {
//         if (node != null) {
//             for (var i:node.children) {
//                 visit(i);
//             }
//             ans.add(node.val);
//         }
//     }
// }

class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        return Stream.concat(
                root.children.stream()
                .flatMap(child -> postorder(child).stream())
                , Stream.of(root.val))
                .collect(Collectors.toList());
    }
}