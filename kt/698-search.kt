class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sums = nums.sum()
        if (sums % k != 0) return false

        val target = sums / k
        nums.sort()
        if (nums.last() > target) return false
        val visited = BooleanArray(nums.size)

        fun dfs(idx: Int, cur: Int, cnt: Int): Boolean {
            if (cnt == k) return true
            if (cur == target) return dfs(nums.size - 1, 0, cnt + 1)
            for (i in (0..idx).reversed()) {
                if (visited[i] || cur + nums[i] > target) continue;
                visited[i] = true
                if(dfs(idx - 1, cur + nums[i], cnt)) return true
                visited[i] = false
                if (cur == 0) return false
            }

            return false
        }


        return dfs(nums.size - 1, 0, 0)
    }


}