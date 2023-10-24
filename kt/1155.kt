class Solution {
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        var dp1 = IntArray(target+1)
        var dp2 = IntArray(target+1)
        val mod = 1000_000_007
        dp1[0] = 1
        for (i in 1..n) {
            for (j in 1..target) {
                for (l in 1..k) {
                    if (j >= l) {
                        dp2[j] = (dp2[j] + dp1[j-l]) % mod
                    }
                }
            }

            dp1 = dp2
            dp2 = IntArray(target+1)
        }

        return dp1[target]
    }
}