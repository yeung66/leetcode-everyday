# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        q = deque([(root, 1)])
        ans = 0
        while q:
            n = len(q)
            width = 1
            head = None
            for _ in range(n):
                # print(q)
                node, no = q.popleft()
                if head is None:
                    head = no
                else:    
                    width = no - head + 1

                if node.left:
                    q.append((node.left, 2 * no))
                if node.right:
                    q.append((node.right, 2 * no + 1))        

            ans = max(ans, width)

        return ans