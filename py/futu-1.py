from collections import defaultdict


n = int(input())
nums = list(map(int, input().split()))


cnt = defaultdict(int)
for i in nums:
    cnt[i] += 1

nums = sorted(set(nums))
cur = []

ans = 0
temp = 0
for i in nums:
    if len(cur) == 0 or ((len(cur) < 3) and cur[0] + 2 >= i):
        cur.append(i)
        temp += cnt[i]
    else:
        while len(cur) > 0 and cur[0] + 2 < i:
            temp -=  cnt[cur[0]]
            cur.pop(0)

        cur.append(i)
        temp += cnt[i]

    ans = max(ans, temp)

print(ans)