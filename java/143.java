/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int len = 0;
        ListNode node1 = head, node2 = head;
        ListNode prev = null;
        while (node2 != null && node2.next != null) {
            prev = node1;
            node1 = node1.next;
            node2 = node2.next.next;
        }

        node1 = reverse(node1);
        prev.next = null;
        ListNode ans = new ListNode(-1);
        while (head != null && node1 != null) {
            // System.out.printf("%d %d\n", head.val, node1.val);
            ans.next = head; head = head.next;
            ans.next.next = node1; node1=node1.next;
            ans = ans.next.next;
        }

        // System.out.printf("%d\n", node1.val);

        if (node1 != null)
            ans.next = node1;

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }

        return head;
    }
}