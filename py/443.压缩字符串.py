#
# @lc app=leetcode.cn id=443 lang=python3
#
# [443] 压缩字符串
#

# @lc code=start
class Solution:
    def compress(self, chars: List[str]) -> int:
        i,j,cnt = 0,0,0
        last = chars[i]
        while i<len(chars):
            if last == chars[i]:
                cnt += 1
                
            else:
                chars[j] = last
                j += 1
                if cnt > 1:
                    for k in str(cnt):
                        chars[j] = str(k)
                        j+=1
                cnt = 1
                last = chars[i]
            i+=1
        if cnt>0:
            chars[j] = last
            j += 1
            if cnt > 1:
                for k in str(cnt):
                    chars[j] = str(k)
                    j+=1

        return j


        
# @lc code=end

