
from bisect import bisect_left


n = int(input())
nums = list(map(int, input().split()))

nums.sort()

ans = 1
for i in range(n):
    l = nums[i]
    idx = bisect_left(nums, l + n)
    # print(i)
    contain = idx - i
    if idx < n and nums[idx] == l + n:
        contain += 1

    ans = max(ans, contain)

print(n - ans)
    