/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = val === undefined ? 0 : val
        this.left = left === undefined ? null : left
        this.right = right === undefined ? null : right
    }
}

function isCousins(root: TreeNode | null, x: number, y: number): boolean {
    let [xParent, xDepth, xFound]: [TreeNode | null, any, any] = [
        null,
        0,
        false,
    ]
    let [yParent, yDepth, yFound]: [TreeNode | null, any, any] = [
        null,
        0,
        false,
    ]

    const dfs = (
        node: TreeNode | null,
        parent: TreeNode | null,
        depth: number
    ) => {
        if (node === null) {
            return
        }

        if (node.val === x) {
            [xParent, xDepth, xFound] = [parent, depth, true]
        } else if (node.val === y) {
            [yParent, yDepth, yFound] = [parent, depth, true]
        }

        if (xFound && yFound) {
            return
        }

        dfs(node.left, node, depth + 1)
        if (xFound && yFound) {
            return
        }
        dfs(node.right, node, depth + 1)
    }

    dfs(root, null, 0)

    return xDepth === yDepth && xParent !== yParent
}
