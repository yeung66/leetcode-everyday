/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        return postorderTraversal(root.left) +
                postorderTraversal(root.right) +
                listOf(root.`val`)
    }
}