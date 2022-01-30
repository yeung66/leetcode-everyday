import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int ones = 0, zeros = 0, n = nums.length;
        int[] points = new int[n + 1];
        for (var i : nums) {
            if (i == 1) {
                ones++;
            }
        }

        points[0] = ones;
        int max = ones;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 1) {
                ones--;
            } else {
                zeros++;
            }
            points[i] = ones + zeros;
            if (max < points[i]) {
                max = points[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (points[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }   
}