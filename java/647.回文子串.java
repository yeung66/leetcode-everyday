/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 *
 * https://leetcode-cn.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (65.66%)
 * Likes:    722
 * Dislikes: 0
 * Total Accepted:    132.3K
 * Total Submissions: 201.2K
 * Testcase Example:  '"abc"'
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        for (int i = 0; i < n; i++) {
            int prev = i - 1;
            int next = i + 1;

            while (prev >= 0 && next < n && s.charAt(prev) == s.charAt(next)) {
                ans++;
                prev--;
                next++;
            }

            if (i != n - 1 && s.charAt(i + 1) == s.charAt(i)) {
                ans++;
                prev = i - 1;
                next = i + 2;

                while (prev >= 0 && next < n && s.charAt(prev) == s.charAt(next)) {
                    ans++;
                    prev--;
                    next++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

