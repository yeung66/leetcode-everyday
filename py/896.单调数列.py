#
# @lc app=leetcode.cn id=896 lang=python3
#
# [896] 单调数列
#

# @lc code=start
class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        # 最Pythonic
        return sorted(A) == A or sorted(A) == A[::-1]

        # 最快
        # sorted_list = sorted(A)
        # return sorted_list == A or sorted_list == A[::-1]

        # 最慢
        # if len(A) < 2: return True 
        # flag = 0
        # for i,num in enumerate(A[:-1]):
        #     if flag == 0:
        #         flag = 1 if A[i+1] > num else -1 if A[i+1] < num else 0
        #     if num > A[i+1] and flag == 1:return False
        #     if num < A[i+1] and flag == -1:return False
        # return True
# @lc code=end

