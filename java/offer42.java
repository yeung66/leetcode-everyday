class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], cnt = nums[0];
        for (int i=1;i<nums.length;i++) {
            cnt = Math.max(cnt, 0) + nums[i];
            ans = Math.max(cnt, ans);
          
        }
        return ans;
    }
}