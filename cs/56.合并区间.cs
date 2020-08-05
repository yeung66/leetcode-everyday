/*
 * @lc app=leetcode.cn id=56 lang=csharp
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (42.73%)
 * Likes:    538
 * Dislikes: 0
 * Total Accepted:    125.5K
 * Total Submissions: 293.6K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */
using System;
using System.Linq;
using System.Collections.Generic;
// @lc code=start
public class Solution {
    public int[][] Merge(int[][] intervals) {
        var ints = new List<int[]>(intervals);
        ints = ints.OrderBy(x=>x[0]).ToList();

        var merged = new List<int[]>();

        foreach(var i in ints)
        {
            if(merged.Count==0 || merged[^1][1] < i[0])
            {
                merged.Add(i);
            }
            else
            {
                merged[^1][1] = Math.Max(merged[^1][1],i[1]);
            }
        }

        return merged.ToArray();
    }
}
// @lc code=end

