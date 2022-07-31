# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        q = [root]
        ans = -1e5 - 1
        ans_level = cur_level = 0
        while q:
            next_q = []
            level_sum = 0
            cur_level += 1
            while q:
                node = q.pop(0)
                level_sum += node.val
                if node.left:
                    next_q.append(node.left)
                if node.right:
                    next_q.append(node.right)

            if level_sum > ans:
                ans = level_sum
                ans_level = cur_level

            q = next_q

        return ans_level