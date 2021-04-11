/*
 * @lc app=leetcode.cn id=264 lang=javascript
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (55.60%)
 * Likes:    509
 * Dislikes: 0
 * Total Accepted:    49.8K
 * Total Submissions: 89.4K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    const dp = new Array(n+1).fill(0)
    dp[1]=1
    let p2=1,p3=1,p5=1

    for(let i=2;i<=n;i++) {
        let num2 = dp[p2]*2,num3=dp[p3]*3,num5=dp[p5]*5
        dp[i]=Math.min(num2,num3,num5)
        // console.log(dp[i])
        if(dp[i]===num2) p2++
        if(dp[i]===num3) p3++
        if(dp[i]===num5) p5++
    }

    return dp[n]

};
// @lc code=end

