# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ans = -10001
        def dfs(node) -> int:
        #     leftSum = rightSum = 0
        #     leftAns = rightAns = -1001
        #     if node.left:
        #         leftSum, leftAns = dfs(node.left)
        #     if node.right:
        #         rightSum, rightAns = dfs(node.right)
            
        #     return max(leftSum, rightSum, 0) + node.val, max(leftAns, rightAns, max(0, leftSum) + max(0, rightSum) + node.val)

        # _, ans = dfs(root)
                if not node:
                    return 0

                nonlocal ans
                left = max(0, dfs(node.left))
                right = max(0, dfs(node.right))

                ans = max(ans, left + right + node.val)
                return node.val + max(left, right)

        dfs(root)

        return ans

            