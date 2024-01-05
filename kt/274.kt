class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        var h = 0
        for (i in citations.indices) {
            val smaller = citations[i].coerceAtMost(citations.size - i)
            h = h.coerceAtLeast(smaller)
        }
        return h
    }
}