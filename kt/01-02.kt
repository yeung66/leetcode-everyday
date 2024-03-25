class Solution {
    fun CheckPermutation(s1: String, s2: String): Boolean {
        val cnt = IntArray(26)
        for (c in s1) {
            cnt[c - 'a']++
        }
        for (c in s2) {
            cnt[c - 'a']--
        }

        return cnt.all { it == 0 }
    }
}