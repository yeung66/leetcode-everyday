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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        
        head = head.next;
        int prev = 0;
        while (head != null) {
            if (head.val == 0) {
                if (prev != 0) {
                    ListNode node = new ListNode(prev);
                    cur.next = node;
                    cur = cur.next;
                    prev = 0;
                }
            } else {
                prev += head.val;
            }
            head = head.next;
        }

        return ans.next;
    }
}