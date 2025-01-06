class Solution:
    def maxConsecutive(self, bottom: int, top: int, special: List[int]) -> int:
        floors = sorted([bottom - 1, top + 1] + special)
        return max(floors[i+1] - floors[i] - 1 for i in range(0, len(floors) - 1))