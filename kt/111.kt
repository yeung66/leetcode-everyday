class Solution {
    fun minDepth(root: TreeNode?): Int {
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            if (node.left == null && node.right == null) return 1
            val left = dfs(node.left)
            val right = dfs(node.right)
            return when {
                node.left == null -> right + 1
                node.right == null -> left + 1
                else -> minOf(left, right) + 1
            }
        }

        return dfs(root)
    }
}