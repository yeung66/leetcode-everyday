class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1, n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ans = Math.max(nums[i] - nums[j], ans);
                }
            }
        }

        return ans;
    }
}