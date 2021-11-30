/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 *
 * https://leetcode-cn.com/problems/nth-digit/description/
 *
 * algorithms
 * Medium (41.45%)
 * Likes:    231
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 63.8K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n
 * 位数字。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
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
    public int findNthDigit(int n) {
        long[] bits = new long[11];
        long times = 1;
        int ans = 0;
        for (int i = 1; i < 11; i++) {
            bits[i] = 9 * times;

            if ((long)n >= bits[i] * i) {
                n -= bits[i] * i;
            } else {
                int x = n / i;
                int y = n % i;
                long num = 1 * times + x - 1;
                if (y == 0)
                    ans = (int) num % 10;
                else {
                    ans = String.valueOf(num + 1).charAt(y - 1) - '0';
                }
                break;
            }

            times *= 10;
        }
        
        return ans;        
    }
}
// @lc code=end

