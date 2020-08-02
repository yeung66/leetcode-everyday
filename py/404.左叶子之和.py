#
# @lc app=leetcode.cn id=404 lang=python3
#
# [404] 左叶子之和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        return self.recur(root,False)

    def recur(self,node,isLeft):
        if not node:return 0
        if not (node.left or node.right):
            return node.val if isLeft else 0
        return self.recur(node.left,True) + self.recur(node.right,False)

        
# @lc code=end

