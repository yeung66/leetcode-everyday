/*
 * @lc app=leetcode.cn id=416 lang=golang
 *
 * [416] 分割等和子集
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (50.94%)
 * Likes:    1060
 * Dislikes: 0
 * Total Accepted:    195.1K
 * Total Submissions: 382.5K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */
package leetcodeeveryday
// @lc code=start
func canPartition(nums []int) bool {
	sum := 0
	for _, i := range nums {
		sum += i
	}

	if sum % 2 != 0 {
		return false
	}

	target := sum / 2
	n := len(nums)
	dp := make([][]int, n + 1)
	for i := range dp {
		dp[i] =  make([]int, target + 1)
	}

	dp[0][0] = 1
	for i := 1; i <= n; i++ {
		num := nums[i-1]
		for j := 0; j <= target; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= num {
				dp[i][j] += dp[i-1][j-num]
			}

		}

		if dp[i][target] > 0 {
			return true
		}
	}

	return false
}
// @lc code=end

