class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 1) {
            return findKth(nums1, nums2, (m + n) / 2 + 1);
        }

        return (findKth(nums1, nums2, (m+n)/2) + findKth(nums1, nums2, (m+n)/2 +1)) / 2.0;
    }

    public double findKth(int[] nums1, int[] nums2, int k) {
        int l1 = 0, l2 =  0;
        int m = nums1.length, n = nums2.length;

        while (k > 0) {
            if (l1 == m) return nums2[l2 + k - 1];
            if (l2 == n) return nums1[l1 + k - 1];

            if (k == 1) break;


            // System.out.printf("%d %d %d\n", l1, l2, k);

            int i1 = l1 + k / 2 - 1, i2 = l2 + k / 2 - 1;
            i1 = i1 >= m ? m - 1 : i1;
            i2 = i2 >= n ? n - 1 : i2;

            // System.out.printf("%d %d %d\n", i1, i2, k);

            if (nums1[i1] <= nums2[i2]) {
                k -= (i1 - l1 + 1);
                l1 = i1 + 1;
            } else {
                k -= (i2 - l2 + 1);
                l2 = i2 + 1;
            }
        }

        return nums1[l1] < nums2[l2] ? nums1[l1] : nums2[l2];
    }
}