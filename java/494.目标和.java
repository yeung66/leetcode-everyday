/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 *
 * https://leetcode-cn.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (44.38%)
 * Likes:    401
 * Dislikes: 0
 * Total Accepted:    45.7K
 * Total Submissions: 102.9K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或
 * -中选择一个符号添加在前面。
 * 
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * 一共有5种方法让最终目标和为3。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // int n = nums.length;
        // int[][] dp = new int[n][2001];
        // dp[0][1000 + nums[0]] += 1;
        // dp[0][1000 - nums[0]] += 1;
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < 2001; j++) {
        //         if (dp[i - 1][j] > 0) {
        //             dp[i][j + nums[i]] += dp[i - 1][j];
        //             dp[i][j - nums[i]] += dp[i - 1][j];
        //         }
        //     }
        // }

        // return dp[n - 1][1000 + S];

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - S;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
// @lc code=end
