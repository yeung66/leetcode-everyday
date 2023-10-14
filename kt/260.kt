class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        val xorSum = nums.reduce { acc, i -> acc xor i }
        val lowbit = xorSum and -xorSum
        val ans = intArrayOf(0, 0)
        nums.forEach {
            if (it and lowbit == 0) {
                ans[0] = ans[0] xor it
            } else {
                ans[1] = ans[1] xor it
            }
        }

        return ans
    }
}