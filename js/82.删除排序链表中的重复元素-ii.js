/*
 * @lc app=leetcode.cn id=82 lang=javascript
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (50.42%)
 * Likes:    522
 * Dislikes: 0
 * Total Accepted:    98.7K
 * Total Submissions: 193.1K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 返回同样按升序排列的结果链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围 [0, 300] 内
 * -100 
 * 题目数据保证链表已经按升序排列
 * 
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
var deleteDuplicates = function(head) {
    if(head==null||head.next==null) return head
    let prev = null, cur = head, next = head.next ,dup = false

    while(cur!=null&&next!=null) {
        if(next.val === cur.val) {
            cur.next = next.next
            next =  next.next
            dup = true
        } else if(dup) {
            if(prev==null) {
                head = next
            } else {
                prev.next = next
            }
            cur = next
            next = next.next
            dup = false
        } else {
            prev = cur
            cur =  next
            next = next.next
        }
    }

    if(dup) {
        if(prev==null) {
            head = next
        } else {
            prev.next = next
        }
    }

    return head

};
// @lc code=end

