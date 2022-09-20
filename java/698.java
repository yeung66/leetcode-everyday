class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length-1] > target) return false;


        int n = nums.length;
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1<<n];

        dp[0] = true;
        for (int i=0;i<1<<n;i++)  {
            if (!dp[i]) continue;

            for (int j=0;j<n;j++) {
                if (nums[j]+curSum[i] > target) break;

                if (((i>>j) & 1) == 0) {
                    int next = i ^ (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % target;
                        dp[next] = true;
                    }
                }
            }
        }

        return dp[(1<<n) - 1];
    }
}