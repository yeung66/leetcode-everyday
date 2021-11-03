import java.util.*;
/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 *
 * https://leetcode-cn.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (70.92%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 59.5K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 美式键盘 中：
 * 
 * 
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：words = ["omk"]
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * words[i] 由英文字母（小写和大写字母）组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = word2Set("qwertyuiop"), row2 = word2Set("asdfghjkl"), row3 = word2Set("zxcvbnm");
        
        return Arrays.stream(words).filter(w -> {
            var chars = word2Set(w.toLowerCase());
            return row1.containsAll(chars) || row2.containsAll(chars) || row3.containsAll(chars);
        }).toArray(String[]::new);
    }

    private Set<Character> word2Set(String word) {
        Set<Character> chars = new HashSet<>();
        for (var c : word.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }
}
// @lc code=end

