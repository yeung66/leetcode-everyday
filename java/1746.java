// https://leetcode-cn.com/problems/maximum-subarray-sum-after-one-operation/

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int prev1 = nums[0], prev2 = nums[0] * nums[0], ans = Math.max(prev1, prev2);

        for (int i = 1; i < nums.length; i++) {
            int cur1 = Math.max(prev1, 0) + nums[i];
            int cur2 = Math.max(prev1 + nums[i] * nums[i], Math.max(prev2 + nums[i], nums[i]*nums[i]));

            prev1 = cur1;
            prev2 = cur2;
            ans = Math.max(ans, Math.max(prev1, prev2));
        }
        
        return ans;
    }
}