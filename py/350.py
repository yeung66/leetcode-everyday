from collections import Counter

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        cnt1 = Counter(nums1)
        cnt2 = Counter(nums2)

        ans = []
        for k, v in cnt1.items():
            if k in cnt2.keys():
                ans.extend([k] * min(v, cnt2[k]))

        return ans
        