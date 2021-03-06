/*
 * @lc app=leetcode.cn id=503 lang=javascript
 *
 * [503] 下一个更大元素 II
 *
 * https://leetcode-cn.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (60.70%)
 * Likes:    336
 * Dislikes: 0
 * Total Accepted:    58K
 * Total Submissions: 95.2K
 * Testcase Example:  '[1,2,1]'
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x
 * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 
 * 注意: 输入数组的长度不会超过 10000。
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {

    const curNums = nums.concat(nums)
    const N = nums.length
    const ans = []
    const stack = []

    console.log(curNums)

    for(let i=curNums.length-1;i> -1;i--){
        let last = stack.length-1
        while(stack.length!==0&&stack[last][1]-i<N&&stack[last][0]<=curNums[i]) {
            stack.pop()
            last = stack.length-1
        }

        if(stack.length===0) {
            ans[i % N] = -1
        }else if(stack[last][1]-i>=N) {
            ans[i % N] = -1
        }else {
            ans[i % N] = stack[last][0]
        }
        console.log(i%N, ans[i%N])

        stack.push([curNums[i], i])
    }

    return ans

};
// @lc code=end

