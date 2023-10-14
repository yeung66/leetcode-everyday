class Solution {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        (0 until 32).forEach { i ->
            var count = 0
            nums.forEach { num ->
                if (num and (1 shl i) != 0) {
                    count++
                }
            }
            if (count % 3 != 0) {
                ans = ans or (1 shl i)
            }
        }
        return ans
    }
}