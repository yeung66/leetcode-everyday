class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)

        if (m + n) % 2 == 1:
            return self.findKth(nums1, nums2, (m+n)//2 + 1) * 1.0

        return (self.findKth(nums1, nums2, (m+n)//2 + 1) + self.findKth(nums1, nums2, (m+n)//2)) / 2

    def findKth(self, nums1: List[int], nums2: List[int], k) -> int:
        m, n = len(nums1), len(nums2)

        l1 = l2 = 0
        while k > 0:
            if l1 == m - 1: return nums2[l2 + k - 1]
            if l2 == n - 1: return nums1[l1 + k - 1]

            if k == 1:
                break

            i1 = l1 + k // 2 - 1 # here use k // 2 - 1 bacause there are at most 2 * (k // 2 - 1) = k - 2 nums less than nums[i1]
            i2 = l2 + k // 2 - 1 # plus itself it may at most be the k-1th large num

            if i1 > m:
                i1 = m - 1
            if i2 > n:
                i2 = n - 1
            
            if nums1[i1] < nums2[i2]:
                k -= (i1 - l1 + 1)
                l1 = i1 + 1
            else:
                k -= (i2 - l2 + 1)
                l2 = i2 + 1

        return min(nums1[l1], nums2[l2])