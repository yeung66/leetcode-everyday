class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        distances_most = {}
        ans = 0
        distance = 0
        for i, g in enumerate(garbage):
            ans += len(g)
            if i > 0:
                distance += travel[i - 1]

            for t in 'GPM':
                if t in g:
                    distances_most[t] = distance

        return ans + sum(distances_most.values())
