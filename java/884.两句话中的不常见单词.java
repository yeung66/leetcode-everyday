import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 *
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/description/
 *
 * algorithms
 * Easy (66.12%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    26.6K
 * Total Submissions: 38.6K
 * Testcase Example:  '"this apple is sweet"\n"this apple is sour"'
 *
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s1.length, s2.length <= 200
 * s1 和 s2 由小写英文字母和空格组成
 * s1 和 s2 都不含前导或尾随空格
 * s1 和 s2 中的所有单词间均由单个空格分隔
 * 
 * 
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();
        

        List<String> ans = new ArrayList<>();
        for (var w : s1.split(" ")) {
            if (set1.containsKey(w)) {
                set1.put(w, 2);
            } else {
                set1.put(w, 1);
            }
        }

        for (var w : s2.split(" ")) {
            if (set2.containsKey(w)) {
                set2.put(w, 2);
            } else {
                set2.put(w, 1);
            }
        }

        for (var k : set1.entrySet()) {
            if (k.getValue() == 1 && !set2.containsKey(k.getKey())) {
                ans.add(k.getKey());
            }
        }

        for (var k : set2.entrySet()) {
            if (k.getValue() == 1 && !set1.containsKey(k.getKey())) {
                ans.add(k.getKey());
            }
        }

        return ans.stream().toArray(String[]::new);
    }
}
// @lc code=end

