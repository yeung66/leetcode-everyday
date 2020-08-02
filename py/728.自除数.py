#
# @lc app=leetcode.cn id=728 lang=python3
#
# [728] 自除数
#

# @lc code=start
class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:

        def isNatural(i):
            temp = i
            while temp:
                j = temp % 10
                temp = temp // 10
                if j == 0 or i % j != 0:return False
            return True

        ans = []
        for i in range(left,right+1):
            if isNatural(i): ans.append(i)

        return ans

        

# @lc code=end

