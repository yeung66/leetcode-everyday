class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        # if k >= len(arr):
        #     return max(arr)

        cnt = 0
        large = arr[0]
        idx = 1
        while cnt < k and idx < len(arr):
            next_no = arr[idx]
            if large > next_no:
                cnt += 1
            else:
                large = next_no
                cnt = 1
            idx += 1

        return large
        