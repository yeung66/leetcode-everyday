/*
 * @lc app=leetcode.cn id=219 lang=javascript
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (41.40%)
 * Likes:    257
 * Dislikes: 0
 * Total Accepted:    88.4K
 * Total Submissions: 211.8K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的
 * 绝对值 至多为 k。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    const bucket1 = new Set()
    const bucket2 = new Map()
    const n = nums.length

    for(let i=0;i<nums.length;i++) {
        if(bucket1.has(nums[i])) return true
        
        bucket1.add(nums[i])
        bucket2.set(i, nums[i])

        if(i>=k) {
            bucket1.delete(bucket2.get(i-k))
            bucket2.delete(i-k)
        }
    }

    return false
};
// @lc code=end

