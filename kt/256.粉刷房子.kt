class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        val n = costs.size
        val dp = Array(n) { IntArray(3) }
        costs[0].forEachIndexed { index, i -> dp[0][index] = i }

        for (i in 1 until n) {
            dp[i][0] = minOf(dp[i-1][1], dp[i-1][2]) + costs[i][0]
            dp[i][1] = minOf(dp[i-1][0], dp[i-1][2]) + costs[i][1]
            dp[i][2] = minOf(dp[i-1][0], dp[i-1][1]) + costs[i][2]
        }

        return dp[n-1].minOrNull()!!
    }
}