class Solution {
    fun maximumNumberOfStringPairs(words: Array<String>): Int {
        val words = words.toSet()
        return words.count { it != it.reversed() && it.reversed() in words } / 2
    }
}