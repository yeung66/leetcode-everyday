import java.util.*;
/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 *
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (68.42%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    33.3K
 * Total Submissions: 46K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j])
 * 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 
 * 示例 2:
 * 
 * 
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4 
 * 解释: 这两个单词为 "ab", "cd"。
 * 
 * 示例 3:
 * 
 * 
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0 
 * 解释: 不存在这样的两个单词。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 
 * 1 
 * words[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> count = new HashMap<>();
        for (var w : words) {
            int mask = 0;
            for (var c : w.toCharArray()) {
                mask |= (1 << (c - 'a' + 1));
            }
            if (count.getOrDefault(mask, 0) < w.length()) {
                count.put(mask, w.length());
            }
        }

        int ans = 0;
        for (var w1 : count.keySet()) {
            for (var w2 : count.keySet()) {
                if ((w1 & w2) == 0) {
                    ans = Math.max(ans, count.get(w1) * count.get(w2));
                }
            }
        }

        return ans;
    }


}
// @lc code=end

