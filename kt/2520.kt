class Solution {
    fun countDigits(num: Int): Int {
        return num.toString().toCharArray().groupBy { it }.map {
            if (num % it.key.digitToInt() == 0) it.value.size else 0
        }.sum()
    }
}