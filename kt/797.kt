class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val n = graph.size
        val ans = mutableListOf<List<Int>>()
        fun dfs(path: MutableList<Int>, node: Int) {
            if (node == n - 1) {
                ans.add(path.toList())
                return
            }
            
            for (next in graph[node]) {
                path.add(next)
                dfs(path, next)
                path.removeAt(path.size - 1)
            }
        }
        
        dfs(mutableListOf(0), 0)
        return ans
    }
}