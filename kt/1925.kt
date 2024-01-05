class Solution {
    fun countTriples(n: Int): Int {
        val squares = (1..n).map { it * it }.toSet()
        return squares.flatMap { a -> squares.map { b -> a to b } }.count {
            (a, b) -> a + b in squares
        }
    }
}