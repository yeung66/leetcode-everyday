class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { acc, i -> acc xor i }
    }
}