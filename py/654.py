# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) <= 1:
            return TreeNode(nums[0]) if len(nums) == 1 else None

        maxVal, maxIdx = -1, -1
        for i, val in enumerate(nums):
            if val > maxVal:
                maxVal, maxIdx = val, i

        root = TreeNode(maxVal)
        root.left = self.constructMaximumBinaryTree(nums[:maxIdx])
        root.right = self.constructMaximumBinaryTree(nums[maxIdx + 1:])

        return root