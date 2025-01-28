class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        farthest = 0

        for i in range(n):
            if i > farthest:
                return False

            if farthest >= n - 1:
                return True

            farthest = max(farthest, i + nums[i])

        return False