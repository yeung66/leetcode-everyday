/*
 * @lc app=leetcode.cn id=475 lang=csharp
 *
 * [475] 供暖器
 */
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System;

// @lc code=start
public class Solution {
    public int FindRadius(int[] houses, int[] heaters) {
        int radius =0, HOUSEMAX = 1000000000;
        Array.Sort(heaters);

        foreach(var house in houses)
        {
            int left=0,right=heaters.Length;
            while(left<right)
            {
                int mid = (left+right)/2;
                // Console.WriteLine(mid);
                if(house > heaters[mid]) left = mid+1;
                else right = mid;
            }
            var dist1 = right==0? HOUSEMAX:Math.Abs(house-heaters[right-1]);
            var dist2 = right==heaters.Length? HOUSEMAX:Math.Abs(house-heaters[right]);
            radius = Math.Max(radius,Math.Min(dist1,dist2));
        }

        return radius;
    }
}
// @lc code=end

