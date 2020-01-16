#
# @lc app=leetcode.cn id=492 lang=python3
#
# [492] 构造矩形
#

# @lc code=start
from math import sqrt

class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        base = int(sqrt(area))
        while area % base != 0:
            base-=1
        return [area // base, base]
# @lc code=end

