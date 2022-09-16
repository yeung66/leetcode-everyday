from collections import defaultdict

s = input()

ans = 0
cnt = defaultdict(int)
cnt[0] = 1
cur = 0

for i in s:
    cur = cur ^ (1 << (ord(i)-ord('a')))
    for j in range(26):
        ans += cnt[cur ^ (1 << j)]
    cnt[cur] += 1

print(ans)