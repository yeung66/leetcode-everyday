/**
 * Definition for singly-linked list.
 *  public class ListNode {
 *   int val; 
 *  ListNode  * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        var temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        while (count > k) {
            head = head.next;
        }

        return head;
    }
}