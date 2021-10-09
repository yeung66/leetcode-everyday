import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 *
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (37.38%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    52.8K
 * Total Submissions: 134.1K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * 示例:
 * 
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        // return (int) Arrays.stream(s.split("\\s+")).filter(x -> !x.equals("")).count();

        int count = 0, index = 0;
        boolean inString = false;
        while (index < s.length()) {
            if (!inString && s.charAt(index) != ' ') {
                count++;
                inString = true;
            } else if (s.charAt(index) == ' ') {
                inString = false;
            }

            index++;
        }

        return count;
    }
}
// @lc code=end

