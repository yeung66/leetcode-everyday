/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (42.56%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    58K
 * Total Submissions: 130.7K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // int ans = 1;
        // while (n > ans) {
        //     n -= ans;
        //     ans++;
        // }
        // return n == ans ? ans : ans - 1;

         return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}
// @lc code=end

