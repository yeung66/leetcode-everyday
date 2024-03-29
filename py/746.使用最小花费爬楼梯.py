#
# @lc app=leetcode.cn id=746 lang=python3
#
# [746] 使用最小花费爬楼梯
#
# https://leetcode-cn.com/problems/min-cost-climbing-stairs/description/
#
# algorithms
# Easy (59.58%)
# Likes:    737
# Dislikes: 0
# Total Accepted:    152.9K
# Total Submissions: 256.4K
# Testcase Example:  '[10,15,20]'
#
# 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
# 
# 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
# 
# 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：cost = [10, 15, 20]
# 输出：15
# 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
# 
# 
# 示例 2：
# 
# 
# 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
# 输出：6
# 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
# 
# 
# 
# 
# 提示：
# 
# 
# cost 的长度范围是 [2, 1000]。
# cost[i] 将会是一个整型数据，范围为 [0, 999] 。
# 
# 
#

# @lc code=start
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        prev1, prev2 = cost[:2]
        for i in range(2, len(cost)):
            cur = min(prev1, prev2) + cost[i]
            prev1, prev2 = prev2, cur

        return min(prev2, prev1)
# @lc code=end

