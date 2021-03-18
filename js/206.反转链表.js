/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (71.47%)
 * Likes:    1594
 * Dislikes: 0
 * Total Accepted:    472.2K
 * Total Submissions: 660.7K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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
 * @return {ListNode}
 */
var reverseList = function(head) {
    if(head==null) return head

    let cur=head, nxt = head.next
    head.next = null
    while(cur!=null&&nxt!=null) {
        // console.log(cur.val, nxt.val)
        let newNext = nxt.next
        nxt.next = cur
        cur = nxt
        nxt = newNext
    }

    return cur
};
// @lc code=end

