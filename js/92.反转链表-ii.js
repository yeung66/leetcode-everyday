/*
 * @lc app=leetcode.cn id=92 lang=javascript
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (53.34%)
 * Likes:    772
 * Dislikes: 0
 * Total Accepted:    124.6K
 * Total Submissions: 233.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
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
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function(head, left, right) {
    if(left===right) return head
    let count = 1
    const ret = head
    while(left>count+1) {
        head = head.next
        count++
    }
    
    const start = head
    let cur = left!==1?head.next:head
    let nxt = cur.next

    count = left
    while(right>count) {
        let newNxt = nxt.next
        nxt.next = cur
        cur = nxt
        nxt = newNxt

        count++
    }

    if(left===1) {
        start.next = nxt
        return cur
    }

    start.next.next = nxt
    start.next = cur

    return ret


    

};
// @lc code=end

