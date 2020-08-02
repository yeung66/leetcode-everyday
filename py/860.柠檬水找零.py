#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change = {5:0,10:0,20:0}

        def deal(count):
            if count == 10:
                if change[5] > 0:
                    change[5]-=1
                    return True
                else:
                    return False
            else:
                if change[10] > 0 and change[5] > 0:
                    change[10]-=1
                    change[5]-=1
                    return True
                elif change[5] > 3:
                    change[5]-=3
                    return True
                return False


        for b in bills:
            change[b]+=1
            if b>5 and not deal(b):return False
        return True
        
# @lc code=end

