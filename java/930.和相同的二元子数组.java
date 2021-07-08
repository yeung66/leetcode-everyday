import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 *
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (41.34%)
 * Likes:    153
 * Dislikes: 0
 * Total Accepted:    17.3K
 * Total Submissions: 33.6K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 
 * 子数组 是数组的一段连续部分。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * nums[i] 不是 0 就是 1
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // hashmap
        // int sum = 0;
        // Map<Integer, Integer> count = new HashMap<>();

        // int ans = 0;
        // for (var i : nums) {
        //     count.put(sum, count.getOrDefault(sum, 0) + 1);
        //     sum += i;
        //     ans += count.getOrDefault(sum - goal, 0);
            
        // }

        // return ans;

        // 滑动窗口
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }

            ans += left2 - left1;
            right++;
        }
        return ans;
    }
}
// @lc code=end

