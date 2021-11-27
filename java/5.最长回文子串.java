/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (35.42%)
 * Likes:    4380
 * Dislikes: 0
 * Total Accepted:    795.1K
 * Total Submissions: 2.2M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "a"
 * 输出："a"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "ac"
 * 输出："a"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由数字和英文字母（大写和/或小写）组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] str = process(s);

        int n = str.length;
        int l = 0, r = 0, ansLength = 0, ansIdx = 1;
        int[] f = new int[n];
        for (int i = 1; i < n - 1; i++) {
            int k = i <= r ? Math.min(r - i, f[l + r - i]) : 0;

            while (i - k >= 0 && i + k < n && str[i - k] == str[i + k]) {
                k++;
            }

            k--;

            f[i] = k;
            if (i + k > r) {
                r = i + k;
                l = i - k;
            }

            if (f[i] > ansLength) {
                ansIdx = i;
                ansLength = f[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        // System.out.printf("%d %d %d\n", ansIdx - ansLength, ansIdx, ansIdx + ansLength);
        for (int i = ansIdx - ansLength; i <= ansIdx + ansLength; i++) {
            if (str[i] != '#')
                sb.append(str[i]);
        }
        return sb.toString();
    }

    public char[] process(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (var c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }

        return sb.toString().toCharArray();
    }
}
// @lc code=end

