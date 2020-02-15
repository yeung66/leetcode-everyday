#
# @lc app=leetcode.cn id=414 lang=python3
#
# [414] 第三大的数
#

# @lc code=start
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        nums = set(nums)
        maxi = max(nums)
        if len(nums) >= 3:
            for _ in range(2):
                nums.remove(maxi)
                maxi = max(nums)
        return maxi
# @lc code=end

