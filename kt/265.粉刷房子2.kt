class Solution {
    fun minCostII(costs: Array<IntArray>): Int {
        var cost1 = Int.MAX_VALUE
        var color1 = -1
        var cost2 = Int.MAX_VALUE

        val n = costs.size
        val k = costs[0].size

        for (i in 0 until k) {
            if (costs[0][i] < cost1) {
                cost2 = cost1
                cost1 = costs[0][i]
                color1 = i
            } else if (costs[0][i] < cost2) {
                cost2 = costs[0][i]
            }
        }

        println(cost1)
        println(cost2)
        println(color1)

        for (i in 1 until n) {
            var curCost1 = Int.MAX_VALUE
            var curColor1 = -1
            var curCost2 = Int.MAX_VALUE
            for (j in 0 until k) {
                val c = costs[i][j] + (if (color1 == j) cost2 else cost1)

                if (c < curCost1) {
                    curCost2 = curCost1
                    curCost1 = c
                    curColor1 = j
                } else if (c < curCost2) {
                    curCost2 = c
                }
            }

            cost1 = curCost1
            cost2 = curCost2
            color1 = curColor1
        }

        return minOf(cost1, cost2)
    }
}