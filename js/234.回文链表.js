/*
 * @lc app=leetcode.cn id=234 lang=javascript
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (46.11%)
 * Likes:    901
 * Dislikes: 0
 * Total Accepted:    212.9K
 * Total Submissions: 461.1K
 * Testcase Example:  '[1,2,2,1]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    // let left = head

    // const traverse = (node) => {
    //     if(node==null) return true
    //     let res = traverse(node.next)

    //     res = res && (left.val === node.val)

    //     left = left.next
    //     return res
    // }

    // return traverse(head)

    // optimize memory usage
    const reverse = (node) => {
        let prev = null, cur = node
        while(cur!=null) {
            let next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }

    let fast = head, slow = head
    while(fast!=null&&fast.next!=null) {
        fast = fast.next.next
        slow = slow.next
    }

    if(fast!=null) slow = slow.next

    let left = head
    let right = reverse(slow)

    while(right!=null) {
        if(left.val!==right.val) {
            return false
        }
        left = left.next
        right = right.next
    }

    return true

};
// @lc code=end

