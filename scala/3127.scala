object Solution {
    def canMakeSquare(grid: Array[Array[Char]]): Boolean = {
        def getRange = for { i <- 0 to 1; j <- 0 to 1} yield (i, j)

        def check(x: Int, y: Int): Boolean = getRange.count((i, j) => grid(x + i)(y + j) == 'B') != 2

        getRange.count((i, j) => check(i, j)) >= 1
    }
}