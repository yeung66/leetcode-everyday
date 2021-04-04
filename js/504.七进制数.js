/*
 * @lc app=leetcode.cn id=504 lang=javascript
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (50.00%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 45.8K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var convertToBase7 = function(num) {

    return num.toString(7)
    // let flag = false
    // if(num<0) {
    //     flag = true
    //     num = Math.abs(num)
    // }

    // let ans = '', digit
    // while(num) {
    //     digit = num % 7
    //     num = Math.floor(num, 7)
    //     ans = `${digit}${ans}`
    // }

    // if(flag) ans = '-' + ans

    // return ans
};
// @lc code=end

