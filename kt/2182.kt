class Solution {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val source = s.asSequence().groupBy { it }
            .map { (k, v) -> k to v.size }
            .toMap()
            .toMutableMap()
        val chars = source.keys.sortedDescending().toMutableList()

        fun MutableMap<Char, Int>.decrease(char: Char) {
            this[char] = this[char]!! - 1
            if (this[char] == 0) {
                chars.remove(char)
            }
        }

        return buildString {
            var cnt = 0
            while (chars.isNotEmpty()) {
                val char = chars[0]
                when {
                    isBlank() || last() != char -> {
                        append(char)
                        source.decrease(char)
                        cnt = 1


                    }

                    cnt < repeatLimit -> {
                        append(char)
                        source.decrease(char)
                        cnt++
                    }

                    else -> {
                        if (chars.size == 1) {
                            return@buildString
                        }

                        append(chars[1])
                        source.decrease(chars[1])
                        cnt = 1
                    }
                }
            }

        }
    }
}

//fun main() {
//    Solution().repeatLimitedString("aababab", 2)
//}

