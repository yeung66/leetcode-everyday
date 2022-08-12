from collections import defaultdict

class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        if not roads: return 0
        cnt = defaultdict(int)
        relations = set()
        for a, b in roads:
            cnt[a] += 1
            cnt[b] += 1
            relations.add((a, b))


        candidates = sorted([(v, k) for k, v in cnt.items()], reverse=True)
        ans = max(i[0] + j[0] - (1 if (i[1], j[1]) in relations or (j[1], i[1]) in relations else 0) for i in candidates for j in candidates if i != j)
        return ans


        
