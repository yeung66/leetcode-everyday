class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            newnums[i] = nums[i];
            newnums[n + i] = nums[i];
        }
        int windowSize = 0;
        for (int i : nums) {
            windowSize += i;
        }

        int left = 0, right = 0, cnt = 0;
        while (right < windowSize) {
            if (nums[right] == 0) {
                cnt++;
            }
            right++;
        }

        int ans = cnt;
        while (left < n) {            
            cnt -= newnums[right] - newnums[left];
            left++;
            right++;
            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}