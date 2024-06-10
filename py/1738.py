class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        heap = [-matrix[0][0]]
        values = [[0 for _ in range(n)] for _ in range(m)]
        values[0][0] = matrix[0][0]

        for i in range(1, m):
            values[i][0] = matrix[i][0] ^ values[i-1][0]
            heapq.heappush(heap, -values[i][0])

        for j in range(1, n):
            values[0][j] = matrix[0][j] ^ values[0][j-1]
            heapq.heappush(heap, -values[0][j])

        for i in range(1, m):
            for j in range(1, n):
                values[i][j] = values[i-1][j-1] ^ values[i-1][j] ^ values[i][j-1] ^ matrix[i][j]
                heapq.heappush(heap, -values[i][j])

        # print(values)
        # print(heap)
        ans = 0
        while k > 0:
            ans = heapq.heappop(heap)
            k -= 1

        return -ans

        