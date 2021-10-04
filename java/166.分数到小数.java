import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (29.89%)
 * Likes:    300
 * Dislikes: 0
 * Total Accepted:    35.3K
 * Total Submissions: 111K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 如果存在多个答案，只需返回 任意一个 。
 * 
 * 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 
 * denominator != 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0)
            return String.valueOf(numeratorLong / denominatorLong);
        
        StringBuilder sb = new StringBuilder();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        int index = 0;
        long remainder = numeratorLong % denominatorLong;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            index++;
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
        }
        
        if (remainder != 0) {
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }

        sb.append(fractionPart.toString());
        return sb.toString();
    }
}
// @lc code=end

