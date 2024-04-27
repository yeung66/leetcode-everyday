class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = searchFirst(nums, target);
        int lastIdx = searchFirst(nums, target + 1);
        return firstIdx < nums.length && nums[firstIdx] == target ?
                new int[] {firstIdx, lastIdx - 1}:
                new int[] {-1, -1};
    }

    public int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}