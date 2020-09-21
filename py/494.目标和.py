#
# @lc app=leetcode.cn id=494 lang=python3
#
# [494] 目标和
#
# https://leetcode-cn.com/problems/target-sum/description/
#
# algorithms
# Medium (44.38%)
# Likes:    401
# Dislikes: 0
# Total Accepted:    45.7K
# Total Submissions: 102.9K
# Testcase Example:  '[1,1,1,1,1]\n3'
#
# 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或
# -中选择一个符号添加在前面。
# 
# 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
# 
# 
# 
# 示例：
# 
# 输入：nums: [1, 1, 1, 1, 1], S: 3
# 输出：5
# 解释：
# 
# -1+1+1+1+1 = 3
# +1-1+1+1+1 = 3
# +1+1-1+1+1 = 3
# +1+1+1-1+1 = 3
# +1+1+1+1-1 = 3
# 
# 一共有5种方法让最终目标和为3。
# 
# 
# 
# 
# 提示：
# 
# 
# 数组非空，且长度不会超过 20 。
# 初始的数组的和不会超过 1000 。
# 保证返回的最终结果能被 32 位整数存下。
# 
# 
#

# @lc code=start
class Solution:

    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        signs = [1 for _ in range(len(nums))]

        dp = {}

        def dfs(idx, prev=0):
            if (idx, prev) in dp: return dp[(idx, prev)]

            if idx == len(nums):
                if prev == S: return 1
                else: return 0
            else:
                result = dfs(idx + 1, prev + nums[idx]) + dfs(idx + 1, prev - nums[idx])
                dp[(idx, prev)] = result

                return result


        return dfs(0)
# @lc code=end

