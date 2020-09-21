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
# dp[i][j] = 0
# dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]]
# @lc code=start
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
       

        if sum(nums) % 2 == 1: return False 
        

        target = sum(nums) // 2
        # print(target)

        if  any(i>target for i in nums): return False

        dp = [[False for _ in range(target + 1)] for _ in range(len(nums))]

        for i in range(len(nums)): 
            dp[i][nums[i]] = True
            dp[i][0] = True

        

        for i in range(1, len(nums)):
            for j in range(1, target + 1):
                if j >= nums[i]:
                    dp[i][j] = dp[i][j] or dp[i-1][j] or dp[i-1][j-nums[i]]
                else:
                    dp[i][j] = dp[i][j] or dp[i-1][j]

        return dp[-1][target]
        


        
# @lc code=end

