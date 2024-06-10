class Solution:
    def numberOfWeeks(self, milestones: List[int]) -> int:
        maxm = max(milestones)
        rest = sum(milestones) - maxm
        return maxm + rest if rest + 1 >= maxm else 2 * rest + 1