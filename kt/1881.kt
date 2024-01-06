class Solution {
    fun maxValue(n: String, x: Int): String {
        return when (n[0]) {
            '-' -> {
                "-" + findTargetValue(n.substring(1), x, true)
            }
            else -> {
                findTargetValue(n, x, false)
            }
        }
    }
}

fun findTargetValue(value: String, x: Int, min: Boolean): String {
    var idx = 0
    val comp = when (min) {
        true -> fun (a: Int, b: Int) = a <= b
        false -> fun (a: Int, b: Int) = a >= b
    }
    while (idx < value.length && comp(value[idx].digitToInt(), x)) {
        idx++
    }

    return "${value.substring(0, idx)}$x${value.substring(idx)}"
}