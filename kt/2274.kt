class Solution {
    fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
        // add the bottom and top to the special array and sort it
        val specialList = special.toMutableList()
        specialList.add(bottom - 1)
        specialList.add(top + 1)
        specialList.sort()
        return specialList.zipWithNext { a, b -> b - a - 1 }.max()
    }
}