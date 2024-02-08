class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val n = nums.size
        val dp = IntArray(n)
        dp[0] = nums[0]
        val deque = ArrayDeque<Int>()
        deque.add(0)
        for (i in 1..<n) {
            while (deque.isNotEmpty() && deque.first() < i - k) {
                deque.removeFirst()
            }
            dp[i] = if (deque.isEmpty()) nums[i] else dp[deque.first()] + nums[i]
            while (deque.isNotEmpty() && dp[deque.last()] <= dp[i]) {
                deque.removeLast()
            }
            deque.add(i)
        }
        return dp[n - 1]
    }
}