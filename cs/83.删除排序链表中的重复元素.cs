/*
 * @lc app=leetcode.cn id=83 lang=csharp
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (52.17%)
 * Likes:    514
 * Dislikes: 0
 * Total Accepted:    209.8K
 * Total Submissions: 397.2K
 * Testcase Example:  '[1,1,2]'
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 
 * 返回同样按升序排列的结果链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
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
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode DeleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur = head, next = head.next;

        while(cur!=null&&next!=null) {
            if(cur.val==next.val) {
                next = next.next;
                while(next!=null&&cur.val==next.val) next = next.next;
                cur.next = next;
                cur = next;
                next = next==null?null:next.next;
            } else {
                cur = next;
                next = next.next;
            }   
        }

        
        return head;
    }

}
// @lc code=end

