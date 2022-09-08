class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for (int i:nums) sum+=i;
        if (sum%2!=0) return false;
        sum/=2;
        
        boolean[] dp = new boolean[sum+1];
        if (nums[0]<=sum)
            dp[nums[0]] = true;
        
        for(int i=0;i<n-1;i++) {
            dp[0]=true;
            boolean[] next=new boolean[sum+1];    
            for(int j=0;j<=sum;j++) {
                if (dp[j]) {
                    next[j] = true;
                    if (j+nums[i+1] <= sum)
                        next[j+nums[i+1]] = true;
                }
            }
            dp = next;
        }

        return dp[sum];
    }
}