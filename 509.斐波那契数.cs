/*
 * @lc app=leetcode.cn id=509 lang=csharp
 *
 * [509] 斐波那契数
 */
using System.Collections.Generic;
// @lc code=start
public class Solution {
    public int Fib(int N) {
        if(!cache.ContainsKey(N)) cache.Add(N, Fib(N-1)+Fib(N-2));
        return cache[N];
    }

    public Dictionary<int,int> cache = new Dictionary<int, int>{{0,0},{1,1}};
}
// @lc code=end

