/*
 * @lc app=leetcode.cn id=1269 lang=javascript
 *
 * [1269] 停在原地的方案数
 *
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
 *
 * algorithms
 * Hard (41.08%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 26.8K
 * Testcase Example:  '3\n2'
 *
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 *
 *
 * 示例  2：
 *
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 *
 *
 * 示例 3：
 *
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 *
 *
 */

// @lc code=start
/**
 * @param {number} steps
 * @param {number} arrLen
 * @return {number}
 */
var numWays = function (steps, arrLen) {
  const bound = Math.min(arrLen - 1, steps);
  const dp = new Array(steps + 1)
    .fill(0)
    .map((_) => new Array(bound + 1).fill(0));
  const mod = 1000000007;
  dp[0][0] = 1;

  for (let i = 1; i <= steps; i++) {
    for (let j = 0; j <= bound; j++) {
      dp[i][j] = dp[i - 1][j];
      if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
      if (j < bound) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
    }
  }

  return dp[steps][0];
};
// @lc code=end
