import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 *
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (57.65%)
 * Likes:    194
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 40.5K
 * Testcase Example:  '[[1,2],[2,3],[3,4]]'
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给出数对的个数在 [1, 1000] 范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (i1, i2) -> i1[0] - i2[0]);

        int n = pairs.length;
        int[] dp = new int[n];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int[] pair1 = pairs[i];
            for (int j = 0; j < i; j++) {
                int[] pair2 = pairs[j];
                if (pair1[0] > pair2[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
// @lc code=end

