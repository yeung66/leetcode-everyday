from collections import Counter


class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        i = x
        while i != self.parent[i]:
            i = self.parent[i]

        while x != self.parent[x]:
            self.parent[x], x = i, self.parent[x]

        return i

    def merge(self, x: int, y: int) -> None:
        x, y = self.find(x), self.find(y)
        self.parent[x] = y

class Solution:
    def largestComponentSize(self, nums: List[int]) -> int:
        uf = UnionFind(max(nums) + 1)
        for num in nums:
            i = 2
            while i * i <= num:
                if num % i == 0:
                    uf.merge(num, i)
                    uf.merge(num, num // i)
                i += 1
        return max(Counter(uf.find(num) for num in nums).values())
