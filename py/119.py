class Solution:
    def getRow(self, rowIndex: int) -> List[int]:

        prev = [1]
        row = []

        for i in range(1, rowIndex + 1):
            row.append(1)
            for j in range(len(prev) - 1):
                row.append(prev[j] + prev[j+1])

            row.append(1)

            prev = row
            row = []

        return prev