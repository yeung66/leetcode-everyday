import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        // // method 1
        // long ans = 0;
        // for (int start = 0; start < nums.length;start++) {
        //     int min = nums[start], max = nums[start];
        //     for (int end = start+1;end < nums.length;end++) {
        //         if (nums[end] < min) {
        //             min = nums[end];
        //         } else if (nums[end] > max) {
        //             max = nums[end];
        //         }

        //         ans += (long) max - min;
        //     }
        // }

        // return ans;

        // method 2
        long[] min = getCount(nums, true), max = getCount(nums, false);
        long ans = 0;
        for (int i=0;i<nums.length;i++) {
            ans += (long) nums[i] * (max[i] - min[i]);
        }

        return ans;
        
    }

    public long[] getCount(int[] nums, boolean isMin) {
        int n = nums.length;
        int[] a = new int[n], b = new int[n];
        Stack<Integer> d = new Stack<>();
        for (int i=0;i<n;i++) {
            while (!d.empty() && (isMin ? nums[d.peek()] >= nums[i] : nums[d.peek()] <= nums[i])) {
                d.pop();
            }

            a[i] = d.empty() ? -1 : d.peek();
            d.push(i);
        }

        d.clear();
        for (int i=n-1;i>=0;i--) {
            while (!d.empty() && (isMin ? nums[d.peek()] > nums[i] : nums[d.peek()] < nums[i])) {
                d.pop();
            }

            b[i] = d.empty() ? n : d.peek();
            d.push(i);
        }

        long[] ans = new long[n];
        for (int i=0;i<n;i++) {
            ans[i] = (i - a[i]) * (b[i] - i);
        }

        return ans;
    }
}