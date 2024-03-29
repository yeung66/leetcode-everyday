class Solution {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 1)
                l++;

            while (l < r && (nums[r] & 1) == 0)
                r--;

            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            r--;
            l++;
        }

        return nums;
    }

}