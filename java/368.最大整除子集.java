import java.util.*;


/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 *
 * https://leetcode-cn.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (45.91%)
 * Likes:    407
 * Dislikes: 0
 * Total Accepted:    43.1K
 * Total Submissions: 94K
 * Testcase Example:  '[1,2,3]'
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i],
 * answer[j]) 都应当满足：
 * 
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 
 * 
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * nums 中的所有整数 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int max = 0, maxVal = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                maxVal = nums[i];
            }
        }
        
        if (max == 1)
            return List.of(nums[0]);

        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0 && max > 0; i--) {
            if (dp[i] == max && maxVal % nums[i] == 0) {
                max--;
                maxVal = nums[i];
                ans.add(nums[i]);
            }
        }
        
        return ans;
    }
}
// @lc code=end

