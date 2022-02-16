/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reversePrint(head *ListNode) []int {
    ans := make([]int, 0)
    for head != nil {
        ans = append(ans, head.Val)
        head = head.Next
    }

    for i:=0;i<len(ans)/2;i++ {
        ans[i], ans[len(ans) - i - 1] = ans[len(ans) - i - 1], ans[i]
    }

    return ans
}