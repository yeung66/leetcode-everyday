const val MOD = 1000000007
class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()
        return (maxLength(horizontalCuts, h).toLong() * maxLength(verticalCuts, w).toLong() % MOD ).toInt()
    }

    fun maxLength(arr: IntArray, boardLength: Int): Int {
        var pre = 0
        var max = 0
        for (i in arr.indices) {
            val cur = arr[i]
            max = max.coerceAtLeast(cur - pre)
            pre = cur
        }

        return max.coerceAtLeast(boardLength - pre)
    }
}