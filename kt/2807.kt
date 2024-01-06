/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode.insert(value: Int): ListNode? {
    val nextNode = this.next
    val node = ListNode(value)
    this.next = node
    node.next = nextNode

    return nextNode
}

tailrec fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

class Solution {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        if (head == null) return null
        var node = head

        while (node!!.next != null) {
            val value = gcd(node.`val`, node.next!!.`val`)
            node = node.insert(value)
        }

        return head
    }
}