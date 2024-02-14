class Solution {
    fun recoverTree(root: TreeNode?): Unit {
        val list = mutableListOf<TreeNode>()
        val values = mutableListOf<Int>()
        fun inorder(root: TreeNode?) {
            if (root == null) return
            inorder(root.left)
            list.add(root)
            values.add(root.`val`)
            inorder(root.right)
        }
        
        inorder(root)
        
        values.sort()
        for (i in list.indices) {
            list[i].`val` = values[i]
        }
    }
}