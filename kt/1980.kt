class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {

        data class DictTreeNode(val value: Char, val children: MutableMap<Char, DictTreeNode> = mutableMapOf()) {
            fun findOrCreate(value: Char): DictTreeNode {
                return children.getOrPut(value) { DictTreeNode(value) }
            }
        }

        val root = DictTreeNode('-')
        nums.forEach { num ->
            var node = root
            num.forEach { char ->
                node = node.findOrCreate(char)
            }
        }

        var ans = ""
        fun dfs(node: DictTreeNode, prefix: String) {
            if (ans.isNotBlank() || prefix.length == nums.size) {
                return
            }

            arrayOf('0', '1').forEach {
                if (!node.children.containsKey(it)) {
                    ans = prefix + "$it".repeat(nums[0].length - prefix.length)
                    return
                }

                dfs(node.children[it]!!, prefix + it)
            }
            
        }

        dfs(root, "")
        return ans

    }
}