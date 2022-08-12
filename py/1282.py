from collections import defaultdict
class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        groups = defaultdict(list)
        for idx, i in enumerate(groupSizes):
            groups[i].append(idx)

        ans = []
        for key, val in groups.items():
            idx = 0
            while idx < len(val):
                ans.append(val[idx:idx+key])
                idx += key
        
        return ans