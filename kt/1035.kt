class Solution {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val (m, n) = nums1.size to nums2.size
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = maxOf(dp[i - 1][j - 1] + 1, dp[i][j])
                }
            }
        }

        return dp[m][n]
    }
}