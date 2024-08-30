class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sums = nums.sum()
        if (sums % k != 0) return false

        val target = sums / k
        nums.sort()
        if (nums.last() > target) return false

        val dp = BooleanArray(1 shl nums.size)
        val curSum = IntArray(1 shl nums.size)
        dp[0] = true
        for (i in 0 until (1 shl nums.size)) {
            if (!dp[i]) continue

            for (j in 0 until nums.size) {
                if (curSum[i] + nums[j] > target) break

                if ((i shr j) and 1 == 0) {
                    val next = i or (1 shl j)
                    if (!dp[next]) {
                        dp[next] = true
                        curSum[next] = (curSum[i] + nums[j]) % target
                    }
                }
            }
        }

        return dp[(1 shl nums.size) - 1]
    }
}