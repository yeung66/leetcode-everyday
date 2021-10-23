import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 *
 * https://leetcode-cn.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (46.36%)
 * Likes:    506
 * Dislikes: 0
 * Total Accepted:    64.8K
 * Total Submissions: 122.3K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[3,2,3]
 * 输出：[3]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // var map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        // return map.keySet().stream().filter(k -> map.get(k) > nums.length / 3).collect(Collectors.toList());

        int vote1 = 0, vote2 = 0;
        int ans1 = 0, ans2 = 0;

        for (var i : nums) {
            if (vote1 > 0 && ans1 == i) {
                vote1++;
            } else if (vote2 > 0 && ans2 == i) {
                vote2++;
            } else if (vote1 == 0) {
                ans1 = i;
                vote1 = 1;
            } else if (vote2 == 0) {
                ans2 = i;
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }

        List<Integer> ans = new LinkedList<>();
        int cnt1=0, cnt2=0;
        for (var i : nums) {
            if (i == ans1)
                cnt1++;
            if (i == ans2)
                cnt2++;
        }

        if (vote1 > 0 && cnt1 > nums.length / 3)
            ans.add(ans1);
        if (vote2 > 0 && cnt2 > nums.length / 3)
            ans.add(ans2);

        return ans;
    }
}
// @lc code=end

