class LockingTree(parent: IntArray) {

    val n = parent.size
    val parent = parent

    class Node {
        var parent: Node? = null
        val children = mutableListOf<Node>()
        var locked = -1
    }

    val nodes = Array<Node>(n) { Node() }

    init {
        parent.forEachIndexed { index, i ->
            if (i != -1) {
                nodes[i].children.add(nodes[index])
                nodes[index].parent = nodes[i]
            }
        }
    }

    fun lock(num: Int, user: Int): Boolean {
        return if (nodes[num].locked != -1) {
            false
        } else {
            nodes[num].locked = user
            true
        }
    }

    fun unlock(num: Int, user: Int): Boolean {
        return if (nodes[num].locked == user) {
            nodes[num].locked = -1
            true
        } else {
            false
        }
    }

    fun upgrade(num: Int, user: Int): Boolean {
        val cur = nodes[num]
        if (cur.locked != -1) return false
        if (!checkParent(cur)) return false

        return if (checkChild(cur)) {
            cur.locked = user
            true
        } else {
            false
        }
    }

    tailrec fun checkParent(node: Node): Boolean {
        if (node.locked != -1) return false
        if (node.parent == null) return true

        return checkParent(node.parent!!)

    }

    fun checkChild(node: Node): Boolean {
        var ans = false
        if (node.locked != -1) {
            node.locked = -1
            ans = true
        }

        return node.children.map { checkChild(it) }.fold(false) { acc, b -> acc || b } || ans
    }

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * var obj = LockingTree(parent)
 * var param_1 = obj.lock(num,user)
 * var param_2 = obj.unlock(num,user)
 * var param_3 = obj.upgrade(num,user)
 */