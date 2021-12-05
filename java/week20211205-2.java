/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        if (n <= 1)
            return null;

        int del = n / 2;
        
        temp = head.next;
        ListNode prev = head;

        while (del - 1 > 0) {
            prev = temp;
            temp = temp.next;
            del--;
        }

        prev.next = temp.next;
        return head;
    }
}