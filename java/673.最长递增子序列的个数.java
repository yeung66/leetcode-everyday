import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 *
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (39.30%)
 * Likes:    409
 * Dislikes: 0
 * Total Accepted:    32.7K
 * Total Submissions: 81K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 
 * 
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * 
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] dpCount = new int[n];
        dp[0] = 1;
        dpCount[0] = 1;
        int maxans = 1;
        for (var i = 1; i < n; i++) {
            dp[i] = 1;
            dpCount[i] = 1;
            for (var j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dpCount[i] += dpCount[j];
                    }
                }
            }
            
            if (dp[i] > maxans) {
                maxans = dp[i];
            }
        }

        int ans = 0;
        for (var i = 0; i < n; i++) {
            if (dp[i] == maxans)
                ans += dpCount[i];
        }
        return ans;
    }
}
// @lc code=end

