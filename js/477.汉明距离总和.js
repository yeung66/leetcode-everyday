/*
 * @lc app=leetcode.cn id=477 lang=javascript
 *
 * [477] 汉明距离总和
 *
 * https://leetcode-cn.com/problems/total-hamming-distance/description/
 *
 * algorithms
 * Medium (53.66%)
 * Likes:    171
 * Dislikes: 0
 * Total Accepted:    18.7K
 * Total Submissions: 32.6K
 * Testcase Example:  '[4,14,2]'
 *
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2
 * + 2 + 2 = 6.
 *
 *
 * 注意:
 *
 *
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 *
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var totalHammingDistance = function (nums) {
    let totalAns = 0
    const n = nums.length
    for (let i = 0; i < 30; i++) {
        let c = 0
        for (const val of nums) {
            c += (val >> i) & 1
        }
        totalAns += c * (n - c)
    }
    return totalAns
}
// @lc code=end
