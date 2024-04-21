class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        fun dfs(target: Int, idx: Int, path: List<Int>) {
            if (target == 0) {
                if (path.size == k) ans.add(path)
                return
            }

            if (idx == 10 || path.size >= k) return

            dfs(target, idx + 1, path)
            if (target - idx >= 0) {
                dfs(target - idx, idx + 1, path + idx)
            }
        }

        dfs(n, 1, listOf())

        return ans
    }
}