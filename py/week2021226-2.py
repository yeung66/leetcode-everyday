
class Solution:
    def executeInstructions(self, n: int, startPos: List[int], s: str) -> List[int]:
        m = len(s)
        dir = {'R': (0, 1), 'L': (0, -1), 'U': (-1, 0), 'D': (1, 0)}
        ans = [0 for _ in range(m)]
        for i in range(m):
            x, y = startPos
            for j in range(i, m):
                dx, dy = dir[s[j]]
                x , y = x + dx, y + dy
                if x < 0 or x >= n or y < 0 or y >= n:
                    break
                ans[i] += 1

        return ans