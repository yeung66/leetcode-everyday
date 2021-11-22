// https://leetcode-cn.com/problems/max-consecutive-ones-ii/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            int cur1, cur2;
            if (nums[i] == 1) {
                cur1 = prev1 + 1;
                cur2 = prev2 + 1;
            } else {
                cur1 = 0;
                cur2 = prev1 + 1;
            }

            ans = Math.max(ans, Math.max(cur1, cur2));
            prev1 = cur1;
            prev2 = cur2;
        }

        return ans;
    }
}