/*
 * @lc app=leetcode.cn id=121 lang=csharp
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (54.75%)
 * Likes:    1148
 * Dislikes: 0
 * Total Accepted:    265.3K
 * Total Submissions: 484.5K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意：你不能在买入股票前卖出股票。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 *  -6 4 -2 3 -2
 */
using System;
using System.Linq;
using System.Collections.Generic;
// @lc code=start
public class Solution {
    public int MaxProfit(int[] prices) {
        var diffList = new List<int>();
        for(var i=1;i<prices.Length;i++) {
            diffList.Add(prices[i] - prices[i-1]);
        }

        int max = 0, temp=0;
        foreach(var diff in diffList) {
            if(temp<0) temp = 0;
            temp += diff;
            max = Math.Max(temp,max);
        }

        return max;
    }
}
// @lc code=end

