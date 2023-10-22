const val DIMENSION_MAX = 10_000
const val VOLUME_MAX: Long = 1_000_000_000
const val MASS_MAX = 100

class Solution {
    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val isBulky =  (length >= DIMENSION_MAX || width >= DIMENSION_MAX || height >= DIMENSION_MAX) ||
                (length.toLong() * width.toLong() * height.toLong() >= VOLUME_MAX)
        val isHeavy = mass >= MASS_MAX

        return when {
            isBulky && isHeavy -> "Both"
            isBulky -> "Bulky"
            isHeavy -> "Heavy"
            else -> "Neither"
        }
    }
}