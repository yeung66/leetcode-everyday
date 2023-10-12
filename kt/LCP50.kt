class Solution {
    fun giveGem(gem: IntArray, operations: Array<IntArray>): Int {
        operations.forEach {
            val give = gem[it[0]] / 2
            gem[it[0]] -= give
            gem[it[1]] += give
        }

        return gem.max()!! - gem.min()!!
    }
}