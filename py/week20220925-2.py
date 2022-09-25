class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        maxNum = max(nums)
        dp = [1 for _ in range(len(nums))]
        ans = 1
        for i in range(1,n):
            if nums[i] == nums[i-1]:
                dp[i] = dp[i-1] + 1

            if nums[i] == maxNum:
                ans = max(ans, dp[i])

        return ans
        
        