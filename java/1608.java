class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int idx=0, n=nums.length;
        while (idx<n) {
            if (idx>0&&nums[idx]==nums[idx-1]) {
                idx++;
                continue;
            }

            int x = n - idx;
            if (x<=nums[idx]&&(idx==0||nums[idx-1]<x)) return x;
            idx++;
        }

        return -1;
    }
}