class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        cnt = {}
        for i in pieces:
            cnt[i[0]] = i

        idx = 0
        while idx < len(arr):
            if arr[idx] not in cnt:
                return False

            l = cnt[arr[idx]]
            for i in l:
                if idx >= len(arr) or arr[idx] != i:
                    return False

                idx += 1

        return True

        