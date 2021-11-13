/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 *
 * https://leetcode-cn.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (56.37%)
 * Likes:    170
 * Dislikes: 0
 * Total Accepted:    54.4K
 * Total Submissions: 94.5K
 * Testcase Example:  '"USA"'
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 
 * 
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 
 * 
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：word = "USA"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：word = "FlaG"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        // if(word.length() <= 1) return true;

        // if (Character.isLowerCase(word.charAt(0))) {
        //     for (int i = 1; i < word.length(); i++)
        //         if (!Character.isLowerCase(word.charAt(i)))
        //             return false;
        // } else {
        //     boolean lower = Character.isLowerCase(word.charAt(1));
        //     for (int i = 1; i < word.length(); i++) {
        //         if (Character.isLowerCase(word.charAt(i)) != lower)
        //             return false;
        //     }
        // }
        
        // return true;

        return word.substring(1).toLowerCase().equals(word.substring(1)) || 
                word.toUpperCase().equals(word);

    }
}
// @lc code=end

