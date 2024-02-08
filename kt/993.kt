class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        fun findDepthAndParent(node: TreeNode?, target: Int, depth: Int, parent: TreeNode?): Pair<Int, TreeNode?> {
            if (node == null) {
                return Pair(-1, null)
            }
            if (node.`val` == target) {
                return Pair(depth, parent)
            }
            val left = findDepthAndParent(node.left, target, depth + 1, node)

            if (left.first != -1) {
                return left
            }

            return findDepthAndParent(node.right, target, depth + 1, node)

        }

        val (xDepth, xParent) = findDepthAndParent(root, x, 0, null)
        val (yDepth, yParent) = findDepthAndParent(root, y, 0, null)
        return xDepth == yDepth && xParent != yParent
    }
}