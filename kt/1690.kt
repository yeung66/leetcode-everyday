class Solution {
    fun stoneGameVII(stones: IntArray): Int {
        val memo = Array(stones.size) { IntArray(stones.size) { -1 } }
        val sums = IntArray(stones.size + 1)
        for (i in stones.indices) {
            sums[i + 1] = sums[i] + stones[i]
        }

        fun dfs(i: Int, j: Int): Int {
            if (i == j) return 0
            if (memo[i][j] != -1) return memo[i][j]
            memo[i][j] = maxOf(sums[j + 1] - sums[i + 1] - dfs(i + 1, j), sums[j] - sums[i] - dfs(i, j - 1))
            return memo[i][j]
        }

        return dfs(0, stones.size - 1)
    }
}