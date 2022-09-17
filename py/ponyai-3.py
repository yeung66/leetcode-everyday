from collections import defaultdict, deque

N = int(input())
s = input()

cnt = defaultdict(deque)
for i,c in enumerate(s):
    cnt[c].append(i)

ret = 0
stop = False
while not stop:
    idx = []
    for c in 'pony':
        # print(idx)
        if len(cnt[c]) == 0:
            stop = True
            break
        
        while len(cnt[c]) > 0 and len(idx) > 0 and cnt[c][0] < idx[-1]:
            cnt[c].popleft()

        if len(cnt[c]) == 0:
            stop = True
            break

        idx.append(cnt[c].popleft())

    if not stop:
        ret += 1

print(ret)

# comb = []
# for i in cnt['p']:
#     for j in cnt['o']:
#         for k in cnt['n']:
#             for l in cnt['y']:
#                 if i<j<k<l:
#                     comb.append((i,j,k,l))

# cnt = defaultdict(set)
# def dfs(idx):
#     global ret
#     if idx == len(comb):
#         ret = max(ret, len(cnt[0]))
#         return

#     can = True
#     for i,ii in enumerate(comb[idx]):
#         if ii in cnt[i]:
#             can = False
#             break

#     if can:
#         for i,ii in enumerate(comb[idx]):
#             cnt[i].add(ii)
#         dfs(idx+1)
#         for i,ii in enumerate(comb[idx]):
#             cnt[i].remove(ii)

#     dfs(idx+1)

# dfs(0)

# print(ret)