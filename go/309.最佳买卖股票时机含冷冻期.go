/*
 * @lc app=leetcode.cn id=309 lang=golang
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (61.50%)
 * Likes:    996
 * Dislikes: 0
 * Total Accepted:    133.2K
 * Total Submissions: 216.1K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 */
package leetcodeeveryday
// @lc code=start
func maxProfit(prices []int) int {
	n := len(prices)
	prev1, prev2, prev3 := 0, -prices[0], 0 // 前一天没有持有股票， 持有股票， 前前天没有持有股票（冷静期
	for i := 1; i < n; i++ {
		cur1 := max(prev1, prev2 + prices[i]) // 今天不持有股票 = 前一天没有 或 今天卖出
		cur2 := max(prev2, prev3 - prices[i]) // 今天持有股票 = 前一天持有 或 冷静期后购入 
		prev3 = prev1
		prev1 = cur1
		prev2 = cur2
	}

	return max(prev1, prev2)
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
// @lc code=end

