class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val merged = mutableListOf<IntArray>()
        intervals.forEach {
            if (merged.isEmpty() || merged[merged.lastIndex][1] < it[0]) {
                merged.add(it)
            } else {
                merged[merged.lastIndex][1] = maxOf(merged[merged.lastIndex][1], it[1])
            }
        }

        return merged.toTypedArray()
    }
}