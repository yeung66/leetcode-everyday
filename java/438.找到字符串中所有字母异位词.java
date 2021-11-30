import java.util.*;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (51.77%)
 * Likes:    671
 * Dislikes: 0
 * Total Accepted:    107.8K
 * Total Submissions: 205.8K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCnt = new HashMap<>();
        Map<Character, Integer> sCnt = new HashMap<>();

        for (var c : p.toCharArray()) {
            pCnt.put(c, pCnt.getOrDefault(c, 0) + 1);
        }

        int start = 0, count = 0, n = p.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!pCnt.containsKey(c)) {
                start = i + 1;
                count = 0;
                sCnt.clear();
            } else {
                sCnt.put(c, sCnt.getOrDefault(c, 0) + 1);
                count++;
                if (count == n) {
                    System.out.println(start);
                    if (sCnt.equals(pCnt)) {
                        ans.add(start);
                    }

                    if (sCnt.get(s.charAt(start)) == 1) {
                        sCnt.remove(s.charAt(start));
                    } else {
                        sCnt.put(s.charAt(start), sCnt.get(s.charAt(start)) - 1);
                    }

                    count--;
                    start++;
                }
            }
        }

        return ans;
    }
    
    public void print(Map<Character, Integer> m) {
        for (var e : m.entrySet()) {
            System.out.printf("%d %d\n", e.getKey(), e.getValue());
        }
        System.out.println();
    }
}
// @lc code=end

