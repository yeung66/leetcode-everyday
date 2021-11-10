/*
 * @lc app=leetcode.cn id=747 lang=kotlin
 *
 * [747] 至少是其他数字两倍的最大数
 *
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/description/
 *
 * algorithms
 * Easy (41.57%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    46.1K
 * Total Submissions: 110.3K
 * Testcase Example:  '[3,6,1,0]'
 *
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * nums 中的最大元素是唯一的
 * 
 * 
 */

// @lc code=start
class Solution {
    fun dominantIndex(nums: IntArray): Int {
        if(nums.size == 1) return 0

        var max1 = if(nums)
        var max2 = -1
        for(i in 1 until nums.size) {
            if(nums[i] > nums[max1]) {
                max2 = max1
                max1 = i
                
            }
        }

        return if (nums[max1] >= nums[max2] * 2) max1 else -1
    }
}
// @lc code=end

