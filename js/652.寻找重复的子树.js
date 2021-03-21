/*
 * @lc app=leetcode.cn id=652 lang=javascript
 *
 * [652] 寻找重复的子树
 *
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (56.17%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    20.6K
 * Total Submissions: 36.6K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * 
 * 示例 1：
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * 下面是两个重复的子树：
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * 和
 * 
 * ⁠   4
 * 
 * 
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
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
 * @return {TreeNode[]}
 */
var findDuplicateSubtrees = function(root) {

    const count = new Map()
    const results = []
    
    const traverse = (node) => {
        if(node == null) return '#'

        let left = traverse(node.left)
        let right = traverse(node.right)

        let res =  `${left},${right},${node.val}`

        if(count.has(res) && count.get(res) === 1) {
            results.push(node)
            count.set(res, count.get(res) + 1)
        } else if(!count.has(res)){
            count.set(res, 1)
        }

        return res
    }

    traverse(root)

    return results
};
// @lc code=end

