class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        red, blue = 0, n - 1
        idx = 0
        while idx <= blue:
            if nums[idx] == 0:
                nums[idx], nums[red] = nums[red], nums[idx]
                red += 1
            elif nums[idx] == 2:
                nums[idx], nums[blue] = nums[blue], nums[idx]
                blue -= 1
            else:
                idx += 1
