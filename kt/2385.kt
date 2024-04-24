class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val parents: MutableMap<Int, TreeNode> = mutableMapOf()
        var startNode: TreeNode? = null
        fun fetchParents(node: TreeNode) {
            if (node.`val` == start) startNode = node
            if (node.left != null) {
                parents[node.left!!.`val`] = node
                fetchParents(node.left!!)
            }
            if (node.right != null) {
                parents[node.right!!.`val`] = node
                fetchParents(node.right!!)
            }
        }

        fetchParents(root!!)
        var times = -1
        var queue = ArrayDeque<TreeNode>()
        queue.add(startNode!!)
        val infected = mutableSetOf(start)
        
        while (queue.isNotEmpty()) {
            val next = ArrayDeque<TreeNode>()
            while (queue.isNotEmpty()) {
                val cur = queue.removeFirst()
                if (parents[cur.`val`] != null && !infected.contains(parents[cur.`val`]!!.`val`)) {
                    infected.add(parents[cur.`val`]!!.`val`)
                    next.add(parents[cur.`val`]!!)
                }
                
                if (cur.left != null && !infected.contains(cur.left!!.`val`)) {
                    infected.add(cur.left!!.`val`)
                    next.add(cur.left!!)
                }

                if (cur.right != null && !infected.contains(cur.right!!.`val`)) {
                    infected.add(cur.right!!.`val`)
                    next.add(cur.right!!)
                }
            }
            
            queue = next
            times++
        }

        return times
    }
}