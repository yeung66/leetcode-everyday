#
# @lc app=leetcode.cn id=368 lang=python3
#
# [368] 最大整除子集
#
# https://leetcode-cn.com/problems/largest-divisible-subset/description/
#
# algorithms
# Medium (40.25%)
# Likes:    250
# Dislikes: 0
# Total Accepted:    18.3K
# Total Submissions: 43.3K
# Testcase Example:  '[1,2,3]'
#
# 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i],
# answer[j]) 都应当满足：
# 
# answer[i] % answer[j] == 0 ，或
# answer[j] % answer[i] == 0
# 
# 
# 如果存在多个有效解子集，返回其中任何一个均可。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,3]
# 输出：[1,2]
# 解释：[1,3] 也会被视为正确答案。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1,2,4,8]
# 输出：[1,2,4,8]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 1 
# nums 中的所有整数 互不相同
# 
# 
#

# @lc code=start
class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        f = [[x] for x in nums]
        for j in range(len(nums)):
            for i in range(j):
                if nums[j] % nums[i] == 0 and len(f[i]) + 1 > len(f[j]):
                    f[j] = f[i] + [nums[j]]

        return max(f, key=len)
# @lc code=end

