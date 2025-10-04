class Spreadsheet(rows: Int) {

    val map = mutableMapOf<String, Int>()

    fun setCell(cell: String, value: Int) {
        map[cell] = value
    }

    fun resetCell(cell: String) {
        map.remove(cell)
    }

    fun getValue(formula: String): Int {
        if (formula.startsWith("=")) {
            val cells = formula.substring(1).split("+")
            var sum = 0
            for (cell in cells) {
                sum += if (cell[0] in 'A'..'Z') {
                    map.getOrDefault(cell, 0)
                } else {
                    cell.toInt()
                }
            }
            return sum
        }

        return 0
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * var obj = Spreadsheet(rows)
 * obj.setCell(cell,value)
 * obj.resetCell(cell)
 * var param_3 = obj.getValue(formula)
 */