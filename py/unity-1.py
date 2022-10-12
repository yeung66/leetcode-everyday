#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# min edit cost
# @param str1 string字符串 the string
# @param str2 string字符串 the string
# @param ic int整型 insert cost
# @param dc int整型 delete cost
# @param rc int整型 replace cost
# @return int整型
#
class Solution:
    def minEditCost(self , str1: str, str2: str, ic: int, dc: int, rc: int) -> int:
        # write code here
        n, m = len(str1), len(str2)
        # MAX = float('inf')
        dp = [j * ic for _ in range(m+1)]
        old = 0

        for i in range(1,n+1):
            old = i * dc 
            for j in range(1,m+1):
                if str1[i-1] == str2[j-1]:
                    dp[i][j] = min(dp[j-1], dp[j] + dc, old + ic)
                else:
                    dp[i][j] = min(dp[j-1] + rc, dp[j-1] + dc + ic, 
                    dp[j] + dc, old + ic)

        return dp[m]
