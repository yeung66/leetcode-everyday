/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (72.78%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    73.4K
 * Total Submissions: 99.9K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 10^4] 之间。
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans;

    public int maxDepth(Node root) {
        ans = 0;
        if(root!=null) dfs(root, 1);
        return ans;
    }
    
    void dfs(Node node, int depth) {
        if (node.children == null || node.children.size() == 0)
            ans = Math.max(depth, ans);

        for (Node c : node.children) {
            dfs(c, depth + 1);
        }
    }
}
// @lc code=end

