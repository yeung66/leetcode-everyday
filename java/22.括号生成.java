import java.util.*;
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.25%)
 * Likes:    2121
 * Dislikes: 0
 * Total Accepted:    366.3K
 * Total Submissions: 474K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        dfs(n, 0, new StringBuilder());
        return ans;
    }

    public void dfs(int n, int needRightPar, StringBuilder prev) {
        if (needRightPar == 0 && n == 0) {
            ans.add(prev.toString());
            return;
        }

        if (n > 0) {
            prev.append('(');
            dfs(n - 1, needRightPar + 1, prev);
            prev.deleteCharAt(prev.length() - 1);
        }

        if (needRightPar > 0) {
            prev.append(')');
            dfs(n, needRightPar - 1, prev);
            prev.deleteCharAt(prev.length() - 1);
        }
            
    }
}
// @lc code=end

