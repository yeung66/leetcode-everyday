# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Data:
    def __init__(self, val, node) -> None:
        self.val = val
        self.node = node

    def __lt__(self, node) -> bool:
        return self.val < node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []
        for node in lists:
            if node:
                heapq.heappush(minHeap, Data(node.val, node))

        ret = ans = ListNode()
        while minHeap:
            node = heapq.heappop(minHeap).node
            ans.next = node
            ans = node
            if node.next:
                heapq.heappush(minHeap, Data(node.next.val, node.next))

        return ret.next