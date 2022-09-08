import math

W, Y, x, N = list(map(float, input().split()))
W, N = int(W), int(N)

left = math.ceil(W * x)

for _ in range(N):
    Y += 1
    total = W * Y    
    # print(total, W, Y)
    total -= left * Y
    total += left * 21
    Y = total / W
    # print(total, W, Y)

print(math.ceil(Y))
