/*
 * @lc app=leetcode.cn id=1160 lang=csharp
 *
 * [1160] 拼写单词
 */
using System.Collections.Generic;
using System.Linq;

// @lc code=start
public class Solution {
    
    public int CountCharacters(string[] words, string chars) {
        var totalChars = splitChar(chars);
        var count=0;
        foreach(var word in words)
        {
            var wordChars = splitChar(word);
            bool contain = true;
            foreach(var item in wordChars)
            {
                if(!totalChars.ContainsKey(item.Key)||item.Value>totalChars[item.Key])
                {
                    contain=false;
                    break;
                }
            }
            if(contain) count+=word.Length;
        }
        return count;

    }

    public Dictionary<char,int> splitChar(string word)
    {
        var stuff = new List<char>(word);
        var groups = stuff
            .GroupBy(s => s)
            .Select(s => new { 
                Stuff = s.Key, 
                Count = s.Count() 
            });
        
        return groups.ToDictionary(s => s.Stuff,s=>s.Count);
    }
}
// @lc code=end

