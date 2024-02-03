fun ListNode.deleteNext(node: ListNode) {
    if (node.next != null) {
        node.next = node.next!!.next
    }
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        while (cur?.next != null) {
            if (cur.`val` == cur.next!!.`val`) {
                cur.deleteNext(cur)
            } else {
                cur = cur.next
            }
        }
        
        return head
    }
}