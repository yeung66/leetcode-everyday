class Solution:
    def rotatedDigits(self, n: int) -> int:
        set1 = set([2,5,6,9])
        set2 = set([1,0,8])

        def check(num):
            has = False
            while num > 0:
                low = num % 10
                if low not in set1 and low not in set2:
                    return False

                if low in set1:
                    has = True

                num //= 10

            return has

        return len([i for i in range(1,n+1) if check(i)])