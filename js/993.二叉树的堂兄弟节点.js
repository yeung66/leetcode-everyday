/*
 * @lc app=leetcode.cn id=993 lang=javascript
 *
 * [993] 二叉树的堂兄弟节点
 *
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (52.15%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    30.7K
 * Total Submissions: 56.1K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function(root, x, y) {
    // const heightRecord = new Array(101).fill(-1)
    // const parentRecord = new Array(101).fill(-1)
    // const dfs = (node, height, parent) => {
    //     if(!node) return
    //     heightRecord[node.val] = height
    //     parentRecord[node.val] = parent
    //     dfs(node.left, height+1, node.val)
    //     dfs(node.right, height+1, node.val)
    // }

    // dfs(root, 0, -1)
    // return heightRecord[x]===heightRecord[y] && parentRecord[x]!==parentRecord[y]

    let x_height,x_parent, x_found = false
    let y_height,y_parent, y_found = false
    
    const dfs = (node, height, parent) => {
        if(!node) return

        if(node.val===x) [x_height, x_parent, x_found] = [height, parent, true]
        else if(node.val===y) [y_height, y_parent, y_found] = [height, parent, true]

        if(x_found&&y_found) return

        dfs(node.left, height+1, node.val)
        if(x_found&&y_found) return true
        dfs(node.right, height+1, node.val)
    }

    dfs(root, 0, -1)
    return x_height===y_height&&x_parent!=y_parent
};


// @lc code=end

