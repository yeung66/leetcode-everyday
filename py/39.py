class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(pos, rest):
            nonlocal sequence
            if rest == 0:
                ans.append(sequence[:])
                return

            if pos == len(candidates) or rest < candidates[pos]:
                return

            dfs(pos + 1, rest)

            most = rest // candidates[pos]
            for i in range(1, most + 1):
                sequence.append(candidates[pos])
                dfs(pos + 1, rest - i * candidates[pos])

            sequence = sequence[:-most]

        sequence = []
        ans = []
        candidates.sort()
        dfs(0, target)
        return ans

        