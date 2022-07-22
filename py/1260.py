from typing import List


class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        for _ in range(k):
            last_cols = [row.pop() for row in grid]
            for i, val in enumerate(last_cols):
                grid[(i+1)%len(grid)].insert(0, val)

        return grid