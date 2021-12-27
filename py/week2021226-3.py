from collections import defaultdict
class Solution:
    def getDistances(self, arr: List[int]) -> List[int]:
        record = defaultdict(list)
        for i in range(len(arr)):
            record[arr[i]].append(i)

        ans = defaultdict(int)
        ret = [0 for _ in range(len(arr))]
        for k, v in record.items():
            n = len(v)
            lead = v[0]
            for i in range(1, n):
                ans[k] += abs(v[i] - lead)

            last = v[0]
            ret[last] = ans[k]
            plus, minus = 0, n - 2
            for i in range(1, n):
                diff = v[i] - last
                ans[k] += diff * plus - diff * minus
                ret[v[i]] = ans[k]
                last = v[i]
                plus+=1
                minus-=1


        return ret
