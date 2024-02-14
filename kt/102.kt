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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = ArrayDeque<TreeNode>()
        val result = mutableListOf<List<Int>>()
        if (root == null) return result
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()
            for (i in 0 until size) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                if (node.left != null) queue.add(node.left!!)
                if (node.right != null) queue.add(node.right!!)
            }
            result.add(level)
        }

        return result
    }
}