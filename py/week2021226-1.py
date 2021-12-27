class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        reverse1 = str(num)[::-1]
        reverse2 = str(int(reverse1))[::-1]
        return num == int(reverse2)