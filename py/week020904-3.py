class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        res = 0
        l = 0
        r = 0
        bits = 0
        while l <= r < len(nums):
            if nums[r] & bits == 0:
                bits = bits | nums[r]
                r += 1
                res = max(res, r - l)
            else:
                bits = bits ^ nums[l]
                l += 1

        return res
