import java.util.*;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 *
 * https://leetcode-cn.com/problems/word-break/description/
 *
 * algorithms
 * Medium (51.40%)
 * Likes:    1273
 * Dislikes: 0
 * Total Accepted:    213.3K
 * Total Submissions: 411.4K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：拆分时可以重复使用字典中的单词。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<String> words;
    // Map<String, Boolean> cache;

    // public boolean wordBreak(String s, List<String> wordDict) {
    //     words = new HashSet<>(wordDict);
    //     cache = new HashMap<>();
    //     return find(s);

    // }

    // public boolean find(String s) {
    //     if (cache.containsKey(s))
    //         return cache.get(s);

    //     boolean ans = false;
    //     if (words.contains(s))
    //         ans = true;
    //     else {
    //         for (int i = 1; i < s.length(); i++) {
    //             ans |= find(s.substring(0, i)) && find(s.substring(i));
    //         }

    //     }

    //     cache.put(s, ans);
    //     return ans;
    // }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        words = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i] |= words.contains(s.substring(0, i));
            
            for (int j = 0; j < i; j++) {
                dp[i] |= dp[j] && words.contains(s.substring(j, i));
            }
        }

        return dp[n];
    }
    
}
// @lc code=end

