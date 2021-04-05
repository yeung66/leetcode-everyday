/*
 * @lc app=leetcode.cn id=977 lang=javascript
 *
 * [977] 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (73.15%)
 * Likes:    219
 * Dislikes: 0
 * Total Accepted:    101.6K
 * Total Submissions: 138.9K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 10^4
 * -10^4 
 * nums 已按 非递减顺序 排序
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    const n = nums.length
    if(nums[0]>=0) return nums.map(x=>x*x)
    if(nums[n-1]<=0)  return nums.reverse().map(x=>x*x)

    let ret = [], i=0,j=n-1
    while(i<=j) {
        if(i===j) {
            ret.unshift(nums[i]*nums[i])
            return ret
        }
        else {
            const x = Math.abs(nums[i]), y = Math.abs(nums[j])
            if(x<y) {
                ret.unshift(y*y)
                j--
            } else {
                ret.unshift(x*x)
                i++
            }
        }
    }

};
// @lc code=end

