class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE, minleftidx = -1, max = Integer.MIN_VALUE, maxleftidx = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxleftidx = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minleftidx = i;
            }
        }

        int minright = n - minleftidx, maxright = n - maxleftidx;
        int ans  = Integer.MAX_VALUE;

        if (min == max) {
            return 1;
        }

        ans = Math.min(ans, minleftidx<maxleftidx?maxleftidx+1:minleftidx+1);
        ans = Math.min(ans, minright<maxright?maxright:minright);
        ans = Math.min(ans, minleftidx + 1 + maxright);
        ans = Math.min(ans, minright + maxleftidx + 1);

        return ans;
    }
}