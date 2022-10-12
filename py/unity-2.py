#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param a string字符串 
# @param b string字符串 
# @return string字符串
#
class Solution:
    def sum(self , a: str, b: str) -> str:
        # write code here
        # return str(int(a) + int(b))

        if len(a) < len(b):
            a, b = b, a
        m, n = len(a), len(b)
        ans = ''
        flag = 0
        for i in range(0, n):
            bit = int(a[m-1-i]) + int(b[n-1-i]) + flag
            flag = 0
            if bit >= 10:
                bit = bit % 10
                flag = 1
            ans += str(bit)

        for i in range(n, m):
            bit = int(a[m-1-i]) + flag
            flag = 0
            if bit >= 10:
                bit = bit % 10
                flag = 1
            ans += str(bit)

        if flag > 0:
            ans += str(flag)

        return ans[::-1]