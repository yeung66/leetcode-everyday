class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];

        dp[0] = true;
        dp[2] = valid2(nums, 1);
        if (n == 2) return dp[2];
        
        dp[3] = valid3(nums, 2);
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] && (valid2(nums, i-1))
                    || (dp[i - 3] && valid3(nums, i-1)));

        }
        return dp[n];
    }

    public boolean valid3(int[] nums, int i) {
        return (nums[i] == nums[i - 1] && nums[i] == nums[i - 2])
                || (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2);
    }

    public boolean valid2(int[] nums, int i) {
        return nums[i] == nums[i - 1];
    }
}