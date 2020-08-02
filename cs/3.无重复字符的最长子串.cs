/*
 * @lc app=leetcode.cn id=3 lang=csharp
 *
 * [3] 无重复字符的最长子串
 */
using System.Collections.Generic;
// @lc code=start
public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int left=0,right=0;
        int longest = 0;
        HashSet<char> chars = new HashSet<char>();

        while(right<s.Length)
        {
            if(chars.Contains(s[right])) {
                chars.Remove(s[left]);
                left++;
            }else{
                chars.Add(s[right]);
                right++;
                longest = longest>(chars.Count)?longest:chars.Count;
            }
        }

        return longest;
    }
}
// @lc code=end

