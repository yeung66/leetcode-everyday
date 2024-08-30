class Solution {
    fun longestCommonPrefix(strs: Array<String>) = 
        strs.reduce { acc, str ->
            acc.zip(str).takeWhile { it.first == it.second }.map { it.first }.joinToString("")
        }
}