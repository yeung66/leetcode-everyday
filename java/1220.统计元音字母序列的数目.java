/*
 * @lc app=leetcode.cn id=1220 lang=java
 *
 * [1220] 统计元音字母序列的数目
 *
 * https://leetcode-cn.com/problems/count-vowels-permutation/description/
 *
 * algorithms
 * Hard (52.53%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 19.4K
 * Testcase Example:  '1'
 *
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * 
 * 
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 
 * 
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和
 * "ua"。
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 5
 * 输出：68
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 2 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (((dp[i - 1][1] + dp[i - 1][2]) % MOD) + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][2]) % MOD;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (dp[n][i] + ans) % MOD;
        }

        return ans;
    }
}
// @lc code=end

