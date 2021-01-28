#
# @lc app=leetcode.cn id=416 lang=python3
#
# [416] 分割等和子集
#
# https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
#
# algorithms
# Medium (49.35%)
# Likes:    400
# Dislikes: 0
# Total Accepted:    57.1K
# Total Submissions: 115.6K
# Testcase Example:  '[1,5,11,5]'
#
# 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
# 
# 注意:
# 
# 
# 每个数组中的元素不会超过 100
# 数组的大小不会超过 200
# 
# 
# 示例 1:
# 
# 输入: [1, 5, 11, 5]
# 
# 输出: true
# 
# 解释: 数组可以分割成 [1, 5, 5] 和 [11].
# 
# 
# 
# 
# 示例 2:
# 
# 输入: [1, 2, 3, 5]
# 
# 输出: false
# 
# 解释: 数组不能分割成两个元素和相等的子集.
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        sumCount = sum(nums)
        if sumCount % 2 ==1: return False

        target = sumCount // 2
        if any(map(lambda x:x>target, nums)): return False

        n = len(nums)
        dp = [[False for _ in range(target+1)] for _ in range(n)]
        
        for j in range(n):
            for i in nums[:j+1]+[0]:
                dp[j][i] = True

        for i in range(n-1):
            for j in range(nums[i+1], target+1):
                dp[i+1][j] = dp[i][j-nums[i+1]] or dp[i][j]

        return dp[n-1][target]

        
# @lc code=end

