/*
 * @lc app=leetcode.cn id=354 lang=javascript
 *
 * [354] 俄罗斯套娃信封问题
 *
 * https://leetcode-cn.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (42.86%)
 * Likes:    459
 * Dislikes: 0
 * Total Accepted:    49K
 * Total Submissions: 114.3K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 注意：不允许旋转信封。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 
 * 示例 2：
 * 
 * 
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * envelopes[i].length == 2
 * 1 i, hi 
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[][]} envelopes
 * @return {number}
 */
var maxEnvelopes = function(envelopes) {

    // const used = new Array(envelopes.length).fill(false)
    // const cache = new Array(envelopes.length).fill(-1)

    // const dfs = (width, height, idx) => {
    //     if(cache[idx]!==-1) return cache[idx]

    //     let count = 1
    //     for(let i=0;i<envelopes.length;i++) {
    //         [envWidth, envHeight] = envelopes[i]
    //         if(used[i] || envWidth>=width || envHeight>=height) continue
            
    //         used[i] = true
    //         count = Math.max(dfs(envWidth, envHeight, i)+1, count)
    //         used[i] = false
    //     }

    //     cache[idx] = count
    //     return count
    // } [[30,50],[12,2],[3,4],[12,15]]

    // let ans = 0
    // for(let i=0;i<envelopes.length;i++) {
    //     ans = Math.max(ans, dfs(envelopes[i][0], envelopes[i][1], i))
    // }

    // return ans

    envelopes = envelopes.sort((a,b) => a[0]===b[0]?a[1]-b[1]:a[0]-b[0])
    const dp = new Array(envelopes.length).fill(1)
    console.log(envelopes)

    for(let i=0;i<envelopes.length;i++) {
        for(let j=0;j<i;j++) {
            if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]) {
                dp[i] = Math.max(dp[i], dp[j]+1)
            }
        }
    }

    return Math.max(...dp)

};
// @lc code=end

