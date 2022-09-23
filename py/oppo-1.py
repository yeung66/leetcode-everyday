q = int(input())

for _ in range(q):
    s, t = input(), input()
    if len(s) != len(t):
        print('No')
        continue

    if s == t:
        print('Yes')
        continue

    n = len(s)
    can = False
    for i in range(n-1):
        if s[:i] + s[i+1] + s[i] + s[i+2:] == t:
            print('Yes')
            can = True
            break

    if not can:
        print('No')


            