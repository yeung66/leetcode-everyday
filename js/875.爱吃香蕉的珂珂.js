/*
 * @lc app=leetcode.cn id=875 lang=javascript
 *
 * [875] 爱吃香蕉的珂珂
 *
 * https://leetcode-cn.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (46.64%)
 * Likes:    157
 * Dislikes: 0
 * Total Accepted:    28.6K
 * Total Submissions: 61.3K
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K
 * 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 
 * 
 * 示例 2：
 * 
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 
 * 
 * 示例 3：
 * 
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    let left=1, right = Math.max(...piles) + 1
    let mid

    const canFinish = (k) => {
        let count = 0
        for(let p of piles) {
            if(p<=k) count++
            else count+= Math.ceil(p/k)
        }

        return count<=h
    }

    while(left<right) {
        mid = Math.floor((left+right) / 2)
        if(canFinish(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
};
// @lc code=end

