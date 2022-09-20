import sys

# intervals = []
# for line in sys.stdin:
#     if len(line.strip()) == 0: break
#     start, end = list(map(int, line.split()))
#     intervals.append((start, end))

def count(intervals):
    ends = []
    for i in intervals:
        ends.extend(i)

    ends.sort()
    cnt  = 0
    for i in range(len(ends)-1):
        cnt += ends[i+1] - ends[i]

    return cnt

def count2(intervals):


    hassame = True
    while hassame:
        hassame = False
        n = len(intervals)
        used = [False for _ in range(n)]
        newintervals = []
        for i in range(n):
            if used[i]:
                continue

            s1, e1 = intervals[i]
            for j in range(i+1,n):
                if used[j]:
                    continue

                s2, e2 = intervals[j]
                if not (s1 >= e2 or s2 >= e1):
                    hassame = True
                    used[i] =  True
                    used[j] = True
                    newintervals.append((min(s1,s2),max(e1,e2)))

            if not used[i]:
                newintervals.append(intervals[i])

        intervals = newintervals 

    ret = 0
    for s, e in intervals:
        ret += e - s

    return ret

# print(intervals)
# print(ret)

import random
intervals = list(set([tuple(sorted((random.randint(1,10000), random.randint(1,10000)))) for _ in range(100)]))

print(count(intervals))
print(count2(intervals))

