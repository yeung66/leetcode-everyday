class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        var sum = 0
        var start = 0
        for (i in satisfaction.indices.reversed()) {
            if (sum + satisfaction[i] > 0) {
                sum += satisfaction[i]
            } else {
                start = i + 1
                break
            }
        }


        // println(satisfaction)
        // println(start)

        return satisfaction
            .filterIndexed {idx, _ -> idx >= start}
            .mapIndexed { index, i -> (index + 1) * i }
            .sum()
    }
}

// fun main(args: Array<String>) {
//     println(Solution().maxSatisfaction(intArrayOf(-1,-8,0,5,-7)))
// }