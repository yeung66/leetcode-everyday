#
# @lc app=leetcode.cn id=516 lang=python3
#
# [516] 最长回文子序列
#
# https://leetcode-cn.com/problems/longest-palindromic-subsequence/description/
#
# algorithms
# Medium (57.74%)
# Likes:    373
# Dislikes: 0
# Total Accepted:    36.7K
# Total Submissions: 61.9K
# Testcase Example:  '"bbbab"'
#
# 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
# 
# 
# 
# 示例 1:
# 输入:
# 
# "bbbab"
# 
# 
# 输出:
# 
# 4
# 
# 
# 一个可能的最长回文子序列为 "bbbb"。
# 
# 示例 2:
# 输入:
# 
# "cbbd"
# 
# 
# 输出:
# 
# 2
# 
# 
# 一个可能的最长回文子序列为 "bb"。
# 
# 
# 
# 提示：
# 
# 
# 1 <= s.length <= 1000
# s 只包含小写英文字母
# 
# 
#

# @lc code=start
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = [[0 for _ in range(n)] for _ in range(n)]

        for i in range(n): dp[i][i] = 1

        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1] + 2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])

        return dp[0][n-1]
# @lc code=end


