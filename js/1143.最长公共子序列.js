/*
 * @lc app=leetcode.cn id=1143 lang=javascript
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (61.26%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    93.7K
 * Total Submissions: 151.5K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列
 * 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 *
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 *
 * 示例 2：
 *
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 *
 * 示例 3：
 *
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * text1 和 text2 仅由小写英文字符组成。
 *
 * 3 1
8 2
9 3
12 6
13 11
[
  [
    0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 2, 0, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 2, 3, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 2, 3, 0, 0,
    0, 0, 0, 0, 0, 0,
    0
  ],
  [
    0, 1, 2, 3, 0, 0,    0, 0, 0, 0, 0, 0,    0
  ],
  [
    0, 1, 2, 3, 0, 0,    1, 0, 0, 0, 0, 0,    0
  ],
  [
    0, 1, 2, 3, 0, 0,    1, 0, 0, 0, 0, 1,    0
  ]
]

 *
 */

// @lc code=start
/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
  if (text1.length < text2.length) [text1, text2] = [text2, text1];
  const m = text1.length,
    n = text2.length;
  const dp = (new Array(m+1).fill(0)).map(_=>new Array(n+1).fill(0));


  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (text1[i-1] === text2[j-1]) {
          dp[i][j] = 1 + dp[i-1][j-1]
      } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
      }
    }
  }

  return Math.max(dp[m][n])
};
// @lc code=end
