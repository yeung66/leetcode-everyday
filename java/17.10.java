class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        int cur = -1, count = 0;
        for (var i : nums) {
            if (cur == i) {
                count++;
            } else if (count == 0) {
                cur = i;
                count = 1;
            } else {
                count--;
            }
        }

        count = 0;
        for (var i : nums) {
            if (cur == i)
                count++;
        }
        
        return count * 2 > nums.length ? cur : -1;
    }
}