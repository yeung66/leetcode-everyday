/*
 * @lc app=leetcode.cn id=1738 lang=javascript
 *
 * [1738] 找出第 K 大的异或坐标值
 *
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/description/
 *
 * algorithms
 * Medium (60.34%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    20.4K
 * Total Submissions: 31.3K
 * Testcase Example:  '[[5,2],[1,6]]\n1'
 *
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素
 * matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 *
 * 示例 2：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 *
 * 示例 3：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 *
 * 示例 4：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *
 *
 *
 * 提示：
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 10^6
 * 1 <= k <= m * n
 *
 *
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthLargestValue = function (matrix, k) {
    const m = matrix.length,
        n = matrix[0].length
    const sum = new Array(m).fill(0).map(_=>new Array(n).fill(0))

    sum[0][0] = matrix[0][0]
    for (let i = 1; i < m; i++) {
        sum[i][0] = sum[i - 1][0] ^ matrix[i][0]
    }
    for (let j = 1; j < n; j++) {
        sum[0][j] = sum[0][j - 1] ^ matrix[0][j]
    }

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            sum[i][j] =
                sum[i][j - 1] ^ sum[i - 1][j] ^ sum[i - 1][j - 1] ^ matrix[i][j]
        }
    }

    return sum.flat().sort((a, b) => b - a)[k-1]
}
// @lc code=end
