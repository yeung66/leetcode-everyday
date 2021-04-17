/*
 * @lc app=leetcode.cn id=220 lang=javascript
 *
 * [220] 存在重复元素 III
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (26.53%)
 * Likes:    387
 * Dislikes: 0
 * Total Accepted:    44.3K
 * Total Submissions: 162.2K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j])
 * ，同时又满足 abs(i - j)  。
 * 
 * 如果存在则返回 true，不存在返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -2^31 
 * 0 
 * 0 
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} t
 * @return {boolean}
 */
var containsNearbyAlmostDuplicate = function(nums, k, t) {
    // 桶排序
    const bucket = new Map()
    const n = nums.length

    for(let i=0;i<n;i++) {
        const x = nums[i]
        const idx = getId(x, t+1)
        if(bucket.has(idx)) return true

        if(bucket.has(idx+1)&&Math.abs(bucket.get(idx+1)-x)<=t) return true
        if(bucket.has(idx-1)&&Math.abs(bucket.get(idx-1)-x)<=t) return true

        bucket.set(idx, x)
        if(i>=k) bucket.delete(getId(nums[i-k], t+1))
    }

    return false
};

const getId = (x, w) => {
    return x<0? Math.floor((x+1)/w)-1:Math.floor(x/w)
}
// @lc code=end

