# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        max_height = max_cnt = 0
        def dfs(node, height=1):
            nonlocal max_cnt, max_height            

            if not (node.left or node.right):
                if height > max_height:
                    max_cnt = node.val
                    max_height = height
                elif height == max_height:
                    max_cnt += node.val
            else:
                if node.left:
                    dfs(node.left, height+1)
                if node.right:
                    dfs(node.right, height+1)

        if root:
            dfs(root)

        return max_cnt
            

            

            