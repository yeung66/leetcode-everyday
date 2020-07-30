/*
 * @lc app=leetcode.cn id=2 lang=csharp
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        int flag = 0;
        ListNode res = new ListNode();
        var temp = res;
        while (l1 != null || l2 != null)
        {
            int x,y;
            x=l1?.val??0;
            y=l2?.val??0;
            var sum = x+y + flag;
            flag = 0;
            if (sum >= 10)
            {
                sum -= 10;
                flag = 1;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1?.next;
            l2 = l2?.next;
        }

        if(flag>0)
        {
            temp.next=new ListNode(flag);
        }
        
        return res.next;
        
    }
}
// @lc code=end

