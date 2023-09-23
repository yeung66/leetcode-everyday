class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = Array<IntArray>(n) { IntArray(2) }
        dp[0][1] = nums[0]
        for (i in 1 until n) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1])
    }
}