/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode ans = newList.next;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newList.next = l1;
                ListNode temp = l1.next;
                l1.next = null;
                l1 = temp;
            } else {
                newList.next = l2;
                ListNode temp = l2.next;
                l2.next = null;
                l2 = temp;
            }

            newList = newList.next;
        }

        if (l1 != null) {
            newList.next = l1;
        } else {
            newList.next = l2;
        }

        return ans;
    }
}