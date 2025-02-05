class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        counter = collections.Counter(nums)
        keys = sorted(counter.keys())
        ans = []
        prev = []

        def dfs(pos):
            nonlocal prev

            if pos >= len(keys):
                ans.append(prev[:])
                return

            dfs(pos + 1)
            for _ in range(counter[keys[pos]]):
                prev.append(keys[pos])
                dfs(pos + 1)

            prev = prev[:-counter[keys[pos]]]

        dfs(0)
        return ans
