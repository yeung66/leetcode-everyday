import heapq
import bisect

N, M = list(map(int, input().split()))

nums = list(map(int, input().split()))

def main():
    if N < M:
        print(sum(nums))
        return

    while True:
        curList = sorted(nums[:M])
        windowMin = [(0,curList[0])]
        for i in range(M, N):
            idx = bisect.bisect_left(curList, nums[i-M])
            curList.pop(idx)
            idx = bisect.bisect_left(curList, nums[i])
            curList.insert(idx, nums[i])
            windowMin.append((i-M+1, curList[0]))

        filterWindow = list(filter(lambda x:x[1]>0, windowMin))
        if len(filterWindow) == 0:
            print(sum(nums))
            return

        remove = min(filterWindow, key=lambda x:x[1])
        for i in range(remove[0], remove[0]+M):
            nums[i] -= remove[1]
    
main()