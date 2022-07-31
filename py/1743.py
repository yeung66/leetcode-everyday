class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        toNums = defaultdict(list)

        for x, y in adjacentPairs:
            toNums[x].append(y)
            toNums[y].append(x)

        start = None
        for k, v in toNums.items():
            if len(v) == 1:
                start = k

        prev = start
        cur = toNums[prev][0]
        n = len(adjacentPairs) + 1
        ans = [start, cur]

        # print(toNums)
        while len(ans) < n:
            cur, prev = toNums[cur][0] if toNums[cur][1] == prev else toNums[cur][1], cur
            # print(prev)
            ans.append(cur)

        return ans
