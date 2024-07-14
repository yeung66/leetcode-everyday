class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
    
        @cache
        def dfs(idx: int, prevSum: int):
            if idx == len(nums):
                if prevSum == target:
                    return 1

                return 0

            return dfs(idx + 1, prevSum + nums[idx]) + dfs(idx + 1, prevSum - nums[idx])

        return dfs(0, 0)