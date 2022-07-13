# https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/

class Solution:
    def oddCells(self, m: int, n: int, indices: List[List[int]]) -> int:
        rows = [0 for _ in range(m)]
        cols = [0 for _ in range(n)]

        for x, y in indices:
            rows[x] += 1
            cols[y] += 1

        oddCntRows, evenCntRows = 0, 0
        for i in rows:
            if i % 2 == 1:
                oddCntRows += 1
            else:
                evenCntRows += 1

        oddCntCols, evenCntCols = 0, 0
        for i in cols:
            if i % 2 == 1:
                oddCntCols += 1
            else:
                evenCntCols += 1

        return oddCntRows * evenCntCols + oddCntCols * evenCntRows

