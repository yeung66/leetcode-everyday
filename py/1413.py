class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        ans = 0
        acc = min_acc = 0
        for i in nums:
            acc += i
            if acc < min_acc:
                min_acc = acc

        return 1 if min_acc >= 1 else 1 - min_acc
