class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        n = len(nums)
        def check(idx):
            left = 0
            for i in range(idx - 1, -1, -1):
                if nums[idx] > nums[i]:
                    left = 1
                    break
                elif nums[idx] < nums[i]:
                    left = -1
                    break

            right = 0
            for i in range(idx + 1, n):
                if nums[idx] > nums[i]:
                    right = 1
                    break
                elif nums[idx] < nums[i]:
                    right = -1
                    break

            return left == right and left != 0

        ans = 0
        for i in range(1, n - 1):
            if nums[i] == nums[i - 1]:
                continue

            if check(i):
                ans += 1

        return ans

                    
        