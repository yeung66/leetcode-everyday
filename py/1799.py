from typing import List

cache = {}

def gcd(a, b):
    if a < b:
        a, b = b, a

    if (a, b) not in cache:
        while b != 0:
            a, b = b, a % b

        cache[(a, b)] = a
    return cache[(a, b)]

ret = [0]

class Solution:
    def maxScore(self, nums: List[int]) -> int:
        m = len(nums)
        mask = 1 << m
        dp = [0] * mask
        for i in range(mask):
            bitsCount = bin(i).count('1')
            if bitsCount % 2 == 1:
                continue

            for j in range(m):
                if (i & (1<<j)) == 0:
                    continue

                for k in range(j+1,m):
                    if (i & (1<<k)) == 0:
                        continue

                    dp[i] = max(dp[i], dp[i - (1<<j) - (1<<k)] + gcd(nums[j], nums[k]) * (bitsCount // 2))

            return dp[mask - 1]

