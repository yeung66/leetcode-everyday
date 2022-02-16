/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTreeSub(preorder, 0, n, inorder, 0, n);
    }

    public TreeNode buildTreeSub(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart == pend)
            return null;

        TreeNode root = new TreeNode(preorder[pstart]);
        int iidx = istart;
        while (inorder[iidx] != preorder[pstart]) {
            iidx++;
        }

        int leftCnt = iidx - istart;
        int rightCnt = iend - iidx - 1;

        root.left = buildTreeSub(preorder, pstart + 1, pstart + 1 + leftCnt, inorder, istart, istart + leftCnt);
        root.right = buildTreeSub(preorder, pstart + 1 + leftCnt, pend, inorder, istart + leftCnt + 1, iend);

        return root;
    }
}