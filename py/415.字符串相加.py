#
# @lc app=leetcode.cn id=415 lang=python3
#
# [415] 字符串相加
#

# @lc code=start
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        num1,num2 = (num1,num2) if len(num1) >len(num2) else (num2,num1)
        n,m = len(num1), len(num2)
        num1,num2 = num1[::-1],num2[::-1]
        flag = 0
        ans = ''
        for i in range(m):
            digit = int(num1[i])+int(num2[i]) + flag
            if digit >= 10:
                flag = 1
                digit -= 10
            else:flag=0
            ans = str(digit) + ans

        for i in range(m,n):
            digit = int(num1[i]) + flag
            if digit >= 10:
                flag = 1
                digit -= 10
            else:flag=0
            ans = str(digit) + ans
        return '1' + ans if flag else ans 
# @lc code=end

