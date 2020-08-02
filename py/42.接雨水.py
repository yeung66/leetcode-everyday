#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n < 2: return 0
        maxleft, maxright = [0 for i in range(n)], \
            [0 for i in range(n)]
        
        temp = height[0]
        for i in range(n):
            if height[i] > temp:
                temp = height[i]
            maxleft[i] = temp

        temp = height[-1]
        for i in range(n-1,-1,-1):
            if height[i] > temp:
                temp = height[i]
            maxright[i] = temp

        ans = 0 
        for i in range(n):
            ans += min(maxleft[i],maxright[i]) - height[i]
        return ans

# @lc code=end

