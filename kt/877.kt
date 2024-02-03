class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        val n = piles.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0..<n) {
            dp[i][i] = piles[i]
        }
        for (len in 1..<n) {
            for (i in 0..<n - len) {
                val j = i + len
                dp[i][j] = (piles[i] - dp[i + 1][j]).coerceAtLeast(piles[j] - dp[i][j - 1])
            }
        }
        return dp[0][n - 1] > 0
    }
}