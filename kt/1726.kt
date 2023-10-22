class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        val allTimes = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            for (j in (i..<nums.size)) {
                if (i == j) continue
                val times = nums[i] * nums[j]
                allTimes[times] = allTimes.getOrDefault(times, 0) + 1
            }
        }

        var ans = 0

        for (i in allTimes.keys) {
            if (allTimes[i]!! > 1) {
                ans += allTimes[i]!! * (allTimes[i]!! - 1) * 4
            }
        }
        return ans
    }
}