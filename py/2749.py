class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for i in range(0, 50):
            if num1 - num2 * i < i:
                return -1
            if bin(num1 - num2 * i).count("1") <= i:
                return i
        return -1