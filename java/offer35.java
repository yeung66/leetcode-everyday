/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        for (Node node = head;node !=null;node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        Node ans = new Node(-1);
        Node ret = ans;
        for (Node node = head;node!=null;) {
            Node newNode = node.next;
            Node next = newNode.next;

            newNode.random = node.random == null ? null : node.random.next;
            // newNode.next = newNode.next == null ? null : newNode.next.next;
            ans.next = newNode;
            ans = newNode;
            node = next;
            // System.out.printf("%d %d %d\n", node.val, newNode.val, ans.val);
        }

        for (Node node = head;node!=null;node = node.next) {
            Node newNode = node.next;
            Node next = newNode.next;
            newNode.next = next == null ? null : next.next;
            node.next = next;
            System.out.printf("%d %d %d\n", node.val, newNode.val, next.val);
        }

        

        return ret.next;
    }
}