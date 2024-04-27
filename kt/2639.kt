class Solution {
    fun Int.len(): Int {
        return this.toString().length
    }

    fun findColumnWidth(grid: Array<IntArray>): IntArray {
        val widths = IntArray(grid[0].size)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j].len() > widths[j]) widths[j] = grid[i][j].len()
            }
        }
        return widths
    }
}