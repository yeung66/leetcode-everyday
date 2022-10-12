class Solution:
    def missingTwo(self, nums: List[int]) -> List[int]:
        xor = 0
        n = len(nums) + 2
        nums = nums + list(range(1,n+1))
        for i in nums:
            xor ^= i

        bit = xor & ( -xor ) # get the low bit of 1
        l = r = 0
        for i in nums:
            if (bit & i) >= 1:
                l ^= i
            else:
                r ^= i

        return [l, r]

        
        

        