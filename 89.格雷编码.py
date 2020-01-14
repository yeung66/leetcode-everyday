#
# @lc app=leetcode.cn id=89 lang=python3
#
# [89] 格雷编码
#

# @lc code=start
class Solution:
    def grayCode(self, n: int) -> List[int]:
        if n==0: return [0]
        maxnum = 2 ** n
        answer = [i for i in range(maxnum)]
        used = [0 for i in range(maxnum)]
        used[0] = 1

        def dfs(i):
            if i==maxnum-1: return True
            ans = False
            for j in range(n):
                if ans: return ans
                temp = answer[i] ^ (2**j)
                if not used[temp]:
                    used[temp]=1
                    answer[i+1] = temp
                    ans |= dfs(i+1)
                    used[temp]=0
            return ans

        dfs(0)
        return answer

# @lc code=end

