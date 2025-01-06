import kotlin.math.*

class Solution {
    fun twoEggDrop(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            for (k in 1 until i) {
                dp[i] = min(dp[i], max(k - 1, dp[i - k]) + 1)
            }
        }

        return dp[n]
    }


}