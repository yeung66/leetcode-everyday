/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val)
            return head.next;

        ListNode cur = head;
        ListNode prev = head;
        while (cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }

        if (cur != null) {
            prev.next = cur.next;
        }

        return head;
    }
}