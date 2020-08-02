#
# @lc app=leetcode.cn id=392 lang=python3
#
# [392] 判断子序列
#

# @lc code=start
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i,j = 0, 0
        while i<len(s) and j<len(t):
            if s[i]==t[j]:i+=1
            j+=1
        if i==len(s):return True
        else: return False

    ## DP solution
    # dp[i][j] = 1 if s[:i] is t[j] subsequence
    # dp[i][j] = dp[i-1][j-1] if s[i]==t[j] else dp[i][j-1]
    # dp[0][j] = True
    

# @lc code=end

