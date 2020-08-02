#
# @lc app=leetcode.cn id=506 lang=python3
#
# [506] 相对名次
#

# @lc code=start
class Solution:
    def findRelativeRanks(self, nums: List[int]) -> List[str]:
        nums = [(i,j) for i,j in enumerate(nums)]
        nums.sort(key=lambda x: x[1],reverse=True)
        ranking = [(i,str(r+1)) for r,(i,_) in enumerate(nums)]
        medals = 'Gold Medal|Silver Medal|Bronze Medal'.split('|')
        for i, pair in enumerate(ranking[:3]):
            ranking[i] = (pair[0],medals[i])
        ranking.sort(key=lambda x: x[0])
        return [i[1] for i in ranking]
# @lc code=end

