/*
 * @lc app=leetcode.cn id=476 lang=csharp
 *
 * [476] 数字的补数
 */
using System.Collections.Generic;
using System;
// @lc code=start
public class Solution {
    public int FindComplement(int num) {
        var bits = new List<int>();
        while(num>0)
        {
            bits.Add(num%2);
            num /= 2;
        }
        bits.Reverse();

        var res = 0;
        foreach(var b in bits)
        {
            res = res * 2 + 1 - b;
        }

        return res;
    }
}
// @lc code=end

