# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head

        cnt = 1
        node = head
        odd = odd_root = ListNode()
        even = even_root = ListNode()

        while node is not None:
            print(node.val)
            if cnt % 2 == 1:
                odd.next = node
                odd = odd.next
            else:
                even.next = node
                even = even.next
            
            node = node.next
            cnt += 1

        odd.next = even_root.next
        even.next = None

        return odd_root.next