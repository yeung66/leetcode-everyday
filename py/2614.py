class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        n = len(nums)
        numsInDiagoanl = set([nums[i][n-i-1] for i in range(n)] + [nums[i][i] for i in range(n)])
        print(numsInDiagoanl)
        def isPrime(num):
            i = 2
            while i * i <= num:
                if num % i == 0:
                    return False

                i += 1

            return num > 1

        return max(list(filter(isPrime, numsInDiagoanl)) + [0])