N, K = list(map(int, input().split()))

idx, cur = 1, 0
needs = list(map(int, input().split()))
needs = [[i+1,j] for i, j in enumerate(needs)]

while True:
    least = min(needs, key=lambda x:x[1])[1]
    if least * N < K:
        K -= least * N
        needs = [(i, j-least) for i,j in needs if j > least]
        N = len(needs)
    else:
        print(needs[(K-1) % N][0])
        break


