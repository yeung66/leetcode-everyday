class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        allSum = sum(nums)
        sub = 0
        ans = []
        ranking = sorted([(i, idx) for idx, i in enumerate(nums)], reverse=True)
        while ranking:
            i, idx = ranking.pop(0)
            allSum, sub = allSum - i, sub + i
            ans.append(i)
            if sub > allSum:
                return ans
                