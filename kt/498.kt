class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        var (x, y) = 0 to 0
        val (m, n) = mat.size to mat[0].size
        val result = IntArray(m * n)
        for (i in result.indices) {
            result[i] = mat[x][y]
            if ((x + y) % 2 == 0) {
                if (y == n - 1) x++
                else if (x == 0) y++
                else {
                    x--
                    y++
                }
            } else {
                if (x == m - 1) y++
                else if (y == 0) x++
                else {
                    x++
                    y--
                }
            }
        }
        return result

    }
}