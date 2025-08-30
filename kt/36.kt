class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val n = 9
        for (i in 0 until n) {
            val rowSet = mutableSetOf<Char>()
            val colSet = mutableSetOf<Char>()
            val boxSet = mutableSetOf<Char>()
            for (j in 0 until n) {
                // Check row
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) return false
                }
                // Check column
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) return false
                }
                // Check 3x3 box
                val boxRow = 3 * (i / 3) + j / 3
                val boxCol = 3 * (i % 3) + j % 3
                if (board[boxRow][boxCol] != '.') {
                    if (!boxSet.add(board[boxRow][boxCol])) return false
                }
            }
        }
        
        return true
    }
}