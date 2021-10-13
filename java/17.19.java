class Solution {
    public int[] missingTwo(int[] nums) {
        int idx = 0, extend1 = -1, extend2 = -1, n = nums.length;
        while (idx < n) {
            var x = nums[idx];
            if (x == 0 || x == -1) {
                idx++;
                continue;
            }
            
            x = x - 1;
            if (x == n) {
                extend1 = 0;
                nums[idx] = -1;
            } else if (x == n + 1) {
                extend2 = 0;
                nums[idx] = -1;
            } else {
                nums[idx] = nums[x];
                nums[x] = 0;
            }

        }

        int[] ans = new int[2];
        int i = 0;
        for (idx = 0; idx < n; idx++) {
            if (nums[idx] == -1) {
                ans[i] = idx + 1;
                i++;
            }
        }
        if (i < 2 && extend1 == -1) {
            ans[i] = n + 1;
            i++;
        }
        if (i < 2 && extend2 == -1) {
            ans[i] = n + 2;
        }
       
        return ans;
    }
}