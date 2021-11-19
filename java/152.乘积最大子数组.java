/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (42.09%)
 * Likes:    1364
 * Dislikes: 0
 * Total Accepted:    196.4K
 * Total Submissions: 465.5K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int prevPosProduct = nums[0] >= 0 ? nums[0] : 0;
        int prevNegProduct = nums[0] < 0 ? nums[0] : 0;
        int n = nums.length;
        int ans = nums[0];

        System.out.printf("%d %d\n", prevPosProduct, prevNegProduct);
        for (int i = 1; i < n; i++) {
            int curPosProduct, curNegProduct;
            curPosProduct = Math.max(nums[i], prevPosProduct * nums[i]);
            curNegProduct = Math.min(nums[i], prevPosProduct * nums[i]);
            // if (nums[i] >= 0) {
            //     curPosProduct = Math.max(nums[i], prevPosProduct * nums[i]);
            //     curNegProduct = prevNegProduct * nums[i];
            // } else {
            //     curPosProduct = prevNegProduct * nums[i];
            //     curNegProduct = Math.min(nums[i], prevPosProduct * nums[i]);
            // }

            prevNegProduct = curNegProduct;
            prevPosProduct = curPosProduct;

            ans = Math.max(prevPosProduct, ans);

            System.out.printf("%d %d\n", prevPosProduct, prevNegProduct);
        }

        return ans;
    }
}
// @lc code=end

