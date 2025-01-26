from functools import lru_cache

class Solution:

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        global result
        self.result = []
        self.candidates = sorted(candidates)
        self.dfs(0, 0, target, ())
        return [list(c) for c in set(self.result)]
        

    @lru_cache
    def dfs(self, idx, cnt, target, prev):
        if cnt == target:
            self.result.append(prev)
            
        if cnt >= target or idx >= len(self.candidates):
            return

        self.dfs(idx + 1, cnt, target, prev)
        self.dfs(idx + 1, cnt + self.candidates[idx], target, prev + (self.candidates[idx],))