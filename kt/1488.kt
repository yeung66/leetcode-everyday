class Solution {
    fun avoidFlood(rains: IntArray): IntArray {
        val result = IntArray(rains.size) { -1 }
        val fullLakes = mutableMapOf<Int, Int>()
        val dryDays = mutableListOf<Int>()
        for (i in rains.indices) {
            if (rains[i] == 0) {
                dryDays.add(i)
            } else {
                if (fullLakes.containsKey(rains[i])) {
                    // find the smallest element in dryDays which is larger than fullLakes[rains[i]]
                    var dryDay = -1
                    for (j in dryDays.indices) {
                        if (dryDays[j] > fullLakes[rains[i]]!!) {
                            dryDay = j
                            break
                        }
                    }
                    if (dryDay == -1) {
                        return intArrayOf()
                    }

                    result[dryDays[dryDay]] = rains[i]
                    dryDays.removeAt(dryDay)
                }
                fullLakes[rains[i]] = i
                result[i] = -1
            }
        }
        for (i in dryDays.indices) {
            result[dryDays[i]] = 1
        }
        return result
    }
}