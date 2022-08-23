from collections import defaultdict


names = input().split(',')
cnt = defaultdict(int)
wrong_input = False
for i in names:
    if not str.isalpha(i) or (i.capitalize() != i):
        wrong_input = True
        cnt.clear()
        break
    cnt[i] += 1

rank = [(v, k) for k,v in cnt.items()]
rank.sort(reverse=True)
max_cnt = rank[0][0] if len(rank) > 0 else 0

filter_rank = [i[1] for i in rank if i[0] == max_cnt]
filter_rank.sort()

if not wrong_input and filter_rank:
    print(filter_rank[0])
else:
    print('error.0001')