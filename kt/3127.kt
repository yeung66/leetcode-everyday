class Solution {
    fun canMakeSquare(grid: Array<CharArray>): Boolean {
        val cnt = IntArray(4)
        fun Char.value(): Int = if (this == 'B') 1 else -1

        for (i in 0..2) {
            for (j in 0..2) {
                if ( i < 2 && j < 2) cnt[0] += grid[i][j].value()
                if ( i < 2 && j > 0) cnt[1] += grid[i][j].value()
                if ( i > 0 && j < 2) cnt[2] += grid[i][j].value()
                if ( i > 0 && j > 0) cnt[3] += grid[i][j].value()
            }
        }

        return cnt.any() { it in listOf(2, -2, 4, -4) }
    }
}