from itertools import combinations
from functools import reduce

class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)):
            for sub in combinations(nums, i):
                ans += reduce(lambda a,b:a^b, sub, 0)

        return ans


        