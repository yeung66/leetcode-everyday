class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        sequence = []
        result = []
        freq = sorted(collections.Counter(candidates).items())

        def dfs(pos, rest):
            nonlocal sequence
            if rest == 0:
                result.append(sequence[:])
                return

            if pos == len(freq) or rest < freq[pos][0]:
                return

            dfs(pos + 1, rest)

            most = min(rest // freq[pos][0], freq[pos][1])
            for i in range(1, most + 1):
                sequence.append(freq[pos][0])
                dfs(pos + 1, rest - i * freq[pos][0])

            sequence = sequence[:-most]

        dfs(0, target)
        return result
