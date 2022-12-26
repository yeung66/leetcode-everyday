class Solution {
    fun minOperations(nums: IntArray): Int {
        var count = 0
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1
                nums[i] = nums[i - 1] + 1
            }
        }
        return count
    }
}