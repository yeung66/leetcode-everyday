class Solution {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        return nums1.flatMap { num1 ->
            nums2.map { num2 ->
                if (num1 == num2) num1
                else if (num1 < num2) 10 * num1 + num2 else 10 * num2 + num1
            }
        }.min()
    }
}