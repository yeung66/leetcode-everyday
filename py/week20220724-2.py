from collections import defaultdict
class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        rows = ['|'.join(map(str, i)) for i in grid]
        rowsCnt = defaultdict(int)
        for i in rows:
            rowsCnt[i] += 1

        ans = 0
        for j in range(len(grid)):
            col = []
            for row in grid:
                col.append(row[j])

            ans += rowsCnt['|'.join(map(str, col))]

        return ans