/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (57.90%)
 * Likes:    2818
 * Dislikes: 0
 * Total Accepted:    342.8K
 * Total Submissions: 586.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // method1: dp
        // int n = height.length;
        // int[] leftMax = new int[n];
        // leftMax[0] = height[0];
        // for (var i = 1; i < n; i++) {
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }

        // int[] rightMax = new int[n];
        // rightMax[n - 1] = height[n - 1];
        // for (var i = n - 2; i >= 0; i--) {
        //     rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        // }

        // int ans = 0;
        // for (var i = 0; i < n; i++) {
        //     ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        // }

        // return ans;

        // method2: double pointer
        int n = height.length;
        int left = 0, right = n - 1, leftMax = height[left], rightMax = height[right];
        int ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }
}
// @lc code=end

