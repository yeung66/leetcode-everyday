class BitSet(val n: Int) {
    val bitset = IntArray(n) { it }
    val size = IntArray(n) { 1 }

    fun find(x: Int): Int {
        return if (bitset[x] == x) x else find(bitset[x]).also { bitset[x] = it }
    }

    fun union(x: Int, y: Int) {
        val xRoot = find(x)
        val yRoot = find(y)
        if (xRoot == yRoot) return
        if (size[xRoot] > size[yRoot]) {
            bitset[yRoot] = xRoot
            size[xRoot] += size[yRoot]
        } else {
            bitset[xRoot] = yRoot
            size[yRoot] += size[xRoot]
        }
    }
}

class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val bitset = BitSet(n)
        for (edge in edges) {
            bitset.union(edge[0], edge[1])
        }

        val count = mutableMapOf<Int, Int>()
        for (i in 0..<n) {
            val root = bitset.find(i)
            count[root] = count.getOrDefault(root, 0) + 1
        }

        var ans = 0L
        for (i in 0..<n) {
            val root = bitset.find(i)
            ans += n - bitset.size[root]
        }

        return ans / 2

    }
}