import java.util.*;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 *
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (52.33%)
 * Likes:    610
 * Dislikes: 0
 * Total Accepted:    50.6K
 * Total Submissions: 92.4K
 * Testcase Example:  '"()())()"'
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = ")("
 * 输出：[""]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> curSet = new HashSet<>();
        List<String> ans = new ArrayList<>();

        while (true) {
            for (var a : curSet) {
                if (isValid(a))
                    ans.add(a);
            }

            if (ans.size() > 0)
                return ans;

            Set<String> nextSet = new HashSet<>();
            for (var cur : curSet) {
                for (int i = 0; i < cur.length(); i++) {
                    if (i > 0 && cur.charAt(i) == cur.charAt(i - 1))
                        continue;

                    if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        nextSet.add(cur.substring(0, i) + cur.substring(i + 1));
                    }
                }
            }
            curSet = nextSet;
        }
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                cnt++;
            else if (c == ')')
                cnt--;
            
            if (cnt < 0)
                return false;
        }

        return cnt == 0;
    }
}
// @lc code=end

