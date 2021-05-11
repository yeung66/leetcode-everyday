/*
 * @lc app=leetcode.cn id=1734 lang=javascript
 *
 * [1734] 解码异或后的排列
 *
 * https://leetcode-cn.com/problems/decode-xored-permutation/description/
 *
 * algorithms
 * Medium (45.20%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 14.8K
 * Testcase Example:  '[3,1]'
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1]
 * 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 *
 *
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 3 <= n < 10^5
 * n 是奇数。
 * encoded.length == n - 1
 *
 *
 */

// @lc code=start
/**
 * @param {number[]} encoded
 * @return {number[]}
 */
var decode = function (encoded) {
  const n = encoded.length + 1;
  const total = new Array(n)
    .fill(0)
    .map((_, idx) => idx + 1)
    .reduce((prev, cur) => prev ^ cur, 0);

  const odd = new Array(n)
    .fill(0)
    .map((_, idx) => {
      if (idx % 2 === 1) return encoded[idx];
      else return 0;
    })
    .reduce((prev, cur) => prev ^ cur, 0);

  const init = total ^ odd;
  const ans = [init];
  for (let i of encoded) {
    ans.push(ans[ans.length - 1] ^ i);
  }
  return ans;
};
// @lc code=end
