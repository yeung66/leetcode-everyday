class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0, steps = 0;

        for (int i=0;i<n;i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                end = farthest;
                if (i != n - 1)
                    steps++;
            }
        }

        return steps;
    }
}