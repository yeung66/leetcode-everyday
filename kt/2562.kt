class Solution {
    fun findTheArrayConcVal(nums: IntArray): Long {
        fun rec(nums: IntArray, prev: Long): Long {
            if (nums.isEmpty()) return prev
            if (nums.size == 1) return nums[0].toLong() + prev

            return rec(nums.sliceArray(1..nums.size - 2), prev + (nums[0].toString() + nums[nums.size-1].toString()).toLong())
        }

        return rec(nums, 0)
    }
}