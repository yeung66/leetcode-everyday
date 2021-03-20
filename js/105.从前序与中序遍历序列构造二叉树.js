/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.38%)
 * Likes:    942
 * Dislikes: 0
 * Total Accepted:    168K
 * Total Submissions: 242K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {

    const n = preorder.length
    const build = (preStart, preEnd, inStart, inEnd) => {
        if(preStart>preEnd||inStart>inEnd) return null

        let root = new TreeNode(preorder[preStart])
        // console.log(root.val)

        let inIdx = inStart
        while(inIdx<=inEnd&&inorder[inIdx]!==root.val) inIdx++

        let leftLength = inIdx - inStart
        root.left = build(preStart+1,preStart+leftLength,inStart,inIdx-1)
        root.right = build(preStart+leftLength+1,preEnd,inIdx+1,inEnd)

        return root
    }

    return build(0, n-1, 0, n-1)
};
// @lc code=end

