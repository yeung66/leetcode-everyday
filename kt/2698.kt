const val MAX = 1001
val cache = IntArray(MAX)
class Solution {

    fun punishmentNumber(n: Int): Int {
        if (cache[n] != 0) {
            return cache[n]
        }

        for (i in 1..< MAX) {
            cache[i] = cache[i - 1] + (if (check(i)) i * i else 0)
        }

        return cache[n]
    }

    fun check(num: Int): Boolean {
        val sq = (num * num)
        return splitAndCheck(sq.toString(), num)
    }

    fun splitAndCheck(num: String, sum: Int): Boolean {
        if (num.length == 1 || num.toInt() <= sum) {
            return num.toInt() == sum
        }

        for (i in 1..< num.length) {
            val left = num.substring(0, i).toInt()
            val right = num.substring(i)
            if (sum - left >= 0 && splitAndCheck(right, sum - left)) {
                return true
            }
        }

        return false
    }
}