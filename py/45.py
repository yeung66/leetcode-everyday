class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
            
        cur = 0
        left = nums[0]
        farthest = nums[0]
        farthestIdx = 0
        ans = 1
        while cur + 1 < len(nums):
            
            if left == 0:
                # print(cur, left, farthest)
                ans += 1
                left = farthest - cur
                
            cur += 1
            left -= 1
            if nums[cur] + cur > farthest:
                farthest = nums[cur] + cur
                farthestIdx = cur

        return ans
                
