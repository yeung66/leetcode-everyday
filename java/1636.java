class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i:nums) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }

        for (int i=0;i<nums.length-1;i++) {
            for (int j=0;j<nums.length - i - 1;j++) {
                if (cnt.get(nums[j]) > cnt.get(nums[j+1]) || (cnt.get(nums[j]) == cnt.get(nums[j+1]) && nums[j] < nums[j+1])) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // Arrays.sort(cnt, (a,b) -> cnt.get(a) == cnt.get(b) ? b - a : cnt.get(a) - cnt.get(b));
        return nums;
    }
}