class Solution {
    fun oneEditAway(first: String, second: String): Boolean {
        val len1 = first.length
        val len2 = second.length
        if (len1 < len2) return oneEditAway(second, first)
        var idx = 0
        while (idx < len2 && first[idx] == second[idx]) idx++
        if (len1 == len2) return idx + 1 >= len1 || first.substring(idx + 1) == second.substring(idx + 1)
        return idx + 1 >= len1 || first.substring(idx + 1) == second.substring(idx)
    }
}