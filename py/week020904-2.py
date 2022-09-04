class Solution:
    def numberOfWays(self, startPos: int, endPos: int, k: int) -> int:
        MOD = 1e9 + 7
        dp = [0 for _ in range(3000+1)]
        dp[startPos+1000]=1
        for _ in range(1, k + 1):
            next = [0 for _ in range(3000+1)]
            for j in range(3000+1):                
                next[j] = (dp[j-1] if j - 1 >= 0 else 0) + (dp[j+1] if j + 1 <=3000 else 0) % MOD
            dp = next

        return dp[endPos+1000] % MOD
