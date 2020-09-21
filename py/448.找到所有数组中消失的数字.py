#
# @lc app=leetcode.cn id=448 lang=python3
#
# [448] 找到所有数组中消失的数字
#
# https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
#
# algorithms
# Easy (60.13%)
# Likes:    459
# Dislikes: 0
# Total Accepted:    54.9K
# Total Submissions: 91.3K
# Testcase Example:  '[4,3,2,7,8,2,3,1]'
#
# 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
# 
# 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
# 
# 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
# 
# 示例:
# 
# 
# 输入:
# [4,3,2,7,8,2,3,1]
# 
# 输出:
# [5,6]
# 
# 
#

# @lc code=start
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        
        idx = 0

        while idx < n:
            if nums[idx] == -1: idx += 1
            else:
                
                if nums[nums[idx]-1] == -1:
                    idx += 1
                    continue
                temp = nums[idx]
                nums[idx] = nums[nums[idx]-1]
                nums[temp-1] = -1
                print(temp)

        ans = []

        print(nums)

        for i in range(n):
            if nums[i] != -1: ans.append(i+1)

        return ans

        
# @lc code=end

