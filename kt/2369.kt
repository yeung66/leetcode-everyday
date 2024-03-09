internal class Solution {
    fun validPartition(nums: IntArray): Boolean {
        val n = nums.size
        val dp = BooleanArray(n + 1)
        dp[0] = true
        dp[2] = valid2(nums, 1)
        if (n == 2) return dp[2]
        dp[3] = valid3(nums, 2)
        for (i in 4..n) {
            dp[i] = dp[i - 2] && valid2(nums, i - 1) || dp[i - 3] && valid3(nums, i - 1)
        }
        return dp[n]
    }

    fun valid3(nums: IntArray, i: Int): Boolean {
        return nums[i] == nums[i - 1] && nums[i] == nums[i - 2] || nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2
    }

    fun valid2(nums: IntArray, i: Int): Boolean {
        return nums[i] == nums[i - 1]
    }
}