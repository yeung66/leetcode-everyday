#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#
# https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
#
# algorithms
# Easy (43.15%)
# Likes:    365
# Dislikes: 0
# Total Accepted:    134.7K
# Total Submissions: 303.7K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最小深度。
# 
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
# 
# 说明: 叶子节点是指没有子节点的节点。
# 
# 示例:
# 
# 给定二叉树 [3,9,20,null,null,15,7],
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 返回它的最小深度  2.
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import queue

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root is None: return 0
        
        q = queue.Queue()
        q.put(root)
        height = 1
        times = 1
        next_times = 1

        while not q.empty():
            
            times = next_times
            next_times = 0

            for i in range(times):
                node = q.get()
                leaf = True
                if node.left: 
                    q.put(node.left)
                    next_times += 1
                    leaf = False
                if node.right: 
                    next_times += 1
                    leaf = False
                    q.put(node.right)
                if leaf:
                    return height

            height += 1




# @lc code=end

