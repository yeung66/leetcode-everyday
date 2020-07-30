/*
 * @lc app=leetcode.cn id=520 lang=csharp
 *
 * [520] 检测大写字母
 */
using System.Linq;
// @lc code=start
public class Solution {
    public bool DetectCapitalUse(string word) {
        return word.ToUpper() == word || word.ToLower()==word || Captalize(word) == word;
    }

    public string Captalize(string str)
    {
        if(str.Length<=1) return str;
        return str.ToUpper()[0] + str.ToLower().Substring(1);
    }
}
// @lc code=end

