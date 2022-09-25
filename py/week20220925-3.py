from typing import List

class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        ups = [1 for _ in range(n)]
        downs = [1 for _ in range(n)]

        for i in range(1,n):
            if nums[i] <= nums[i-1]:
                downs[i] = downs[i-1] + 1
            if nums[i] >= nums[i-1]:
                ups[i] = ups[i-1] + 1

        ans = []
        print(downs)
        print(ups)
        for i in range(k, n-k):
            if ups[i+k] >= k and downs[i-1] >= k:
                ans.append(i)

        return ans
