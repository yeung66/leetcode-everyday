class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupLength = 1;
        ListNode p = head;
        ListNode lastGroup = head;
        System.out.println(p.val);
        while (p != null) {
            int cnt = 1;
            ListNode start = p;
            System.out.println(p.val);
            while (p.next != null && cnt < groupLength) {
                p = p.next;
                System.out.println(p.val);
                cnt++;
            }

            ListNode end = p;
            if (end != start && cnt % 2 == 0) {
                System.out.println("enter");
                lastGroup.next = reverseLinkedList(start, end);
                lastGroup = start;
                p = start.next;
            } else {
                p = end.next;
                lastGroup = end;
            }
               
            
            groupLength++;
        }
        
        return head;
    }

    public ListNode reverseLinkedList(ListNode start, ListNode end) {
        ListNode prev = start, cur = start.next, next;
        while (cur != null & prev != end) {

            next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;

        }
        
        start.next = cur;
        return end;
    }
}