
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root

        if not root.left and not root.right:
            return None if root.val == 0 else root

        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)

        if not root.left and not root.right:
            return None if root.val == 0 else root

        return root
