from collections import defaultdict
class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        rank = {k:v for k, v in enumerate(sorted(set(arr)), 1)}
        return [rank[v] for v in arr]
