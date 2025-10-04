class Solution {
    fun maxArea(height: IntArray): Int {
        val n = height.size
        var (left, right) = 0 to n - 1
        var ans = 0

        while (left < right) {
            val h = minOf(height[left], height[right])
            ans = maxOf(ans, h * (right - left))
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return ans
    }
}