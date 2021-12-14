/*
 * @lc app=leetcode.cn id=213 lang=kotlin
 *
 * [213] 打家劫舍 II
 *
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (43.41%)
 * Likes:    855
 * Dislikes: 0
 * Total Accepted:    186.2K
 * Total Submissions: 429K
 * Testcase Example:  '[2,3,2]'
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    fun rob(nums: IntArray): Int {
        var ans = 0
        if (nums.size <= 3) {
            return nums.max()!!
        }
        var prev1 = nums[0]
        var prev2Steal = nums[1]
        var prev2NotSteal = nums[0]
        for (i in 2 until nums.size-1) {
            val steal = maxOf(prev1, prev2NotSteal) + nums[i]
            val notSteal = maxOf(prev1, prev2Steal, prev2NotSteal)

            prev1 = maxOf(prev2Steal, prev2NotSteal)
            prev2Steal = steal
            prev2NotSteal = notSteal
        }

        ans = maxOf(prev2Steal, prev2NotSteal)

        prev1 = nums[1]
        prev2Steal = nums[2]
        prev2NotSteal = nums[1]
        for (i in 3 until nums.size) {
            val steal = maxOf(prev1, prev2NotSteal) + nums[i]
            val notSteal = maxOf(prev1, prev2Steal, prev2NotSteal)

            prev1 = maxOf(prev2Steal, prev2NotSteal)
            prev2Steal = steal
            prev2NotSteal = notSteal
        }

        ans = maxOf(ans, prev2Steal, prev2NotSteal)
        return ans
    }
}
// @lc code=end

