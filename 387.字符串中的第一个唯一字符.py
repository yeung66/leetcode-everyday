#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

class Solution:
    def firstUniqChar(self, s: str) -> int:
        if not s:return -1
        dic = {}
        for i,c in enumerate(s):
            if c in dic:
                dic[c][0]+=1
            else:
                dic[c] = [1,i]
        ans = sorted([v for k,v in dic.items()])
        # print(ans)
        if ans[0][0]==1:return ans[0][1]
        else: return -1
        

