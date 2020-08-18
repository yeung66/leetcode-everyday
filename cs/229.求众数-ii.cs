/*
 * @lc app=leetcode.cn id=229 lang=csharp
 *
 * [229] 求众数 II
 *
 * https://leetcode-cn.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (43.47%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    19.4K
 * Total Submissions: 44.6K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: [3]
 * 
 * 示例 2:
 * 
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * 
 */
using System.Linq;
// @lc code=start
public class Solution
{
    public IList<int> MajorityElement(int[] nums)
    {
        // method 1
        // int threshold = nums.Length / 3;

        // return nums.GroupBy(x=>x)
        //             .Where(x=>x.Count()>threshold)
        //             .Select(x=>x.Key)
        //             .ToList();

        int cand1 = 0, cand2 = 0;
        int cnt1 = 0, cnt2 = 0;

        foreach (var i in nums)
        {
            if (i == cand1)
            {
                cnt1++;
                continue;
            }
            if (i == cand2)
            {
                cnt2++;
                continue;
            }

            // 更换候选1
            if (cnt1 == 0)
            {
                cand1 = i;
                cnt1 = 1;
                continue;
            }

            // 更换候选2
            if (cnt2 == 0)
            {
                cand2 = i;
                cnt2 = 1;
                continue;
            }

            // 同时移除一个cand1、cand2和num
            cnt1--;
            cnt2--;


        }
        cnt1 = 0; cnt2 = 0;
        foreach (var i in nums)
        {
            if (i == cand1) cnt1++;
            else if (i == cand2) cnt2++;
        }

        int threshold = (nums.Length / 3);
        var ans = new List<int>();
        if (cnt1 > threshold) ans.Add(cand1);
        if (cnt2 > threshold) ans.Add(cand2);

        return ans;

    }
}
// @lc code=end

