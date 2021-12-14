class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int left = 0; left < n; left++) {
            int min = nums[left], max = nums[left];
            for (int right = left + 1; right < n; right++) {
                min = Math.min(min, nums[right]);
                max = Math.max(max, nums[right]);
                ans += max - min;
            }
        }

        return ans;
    }
}