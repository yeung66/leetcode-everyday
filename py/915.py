class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        leftPos = 0
        leftMax = curMax = nums[0]
        for i in range(1, len(nums)):
            curMax = max(curMax, nums[i])
            if nums[i] < leftMax:
                leftMax, leftPos = curMax, i

        return leftPos + 1

