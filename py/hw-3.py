
# If you need to import additional packages or classes, please import here.
# D 公里路程，续航 1000 公里的电动车，一小时走一百公里，途中有 N 个充电站，每个充电站需要排队若干事件，充电需要 1 小时，问如何规划充电能够最短时间到达

def solve():
    D = int(input())
    N = int(input())
    charges = []
    for _ in range(N):
        charges.append(list(map(int,input().split())))

    if D <= 1000:
        print(D // 100)
        return


    dp = [[float('inf') for _ in range(1001)] for _ in range(len(charges))]
    if charges[0][0] > 1000:
        print(-1)
        return

    dp[0][1000 - charges[0][0]] = charges[0][0] // 100
    dp[0][1000] = charges[0][0] // 100 + charges[0][1]

    for i in range(1, len(charges)):
        driveTime = (charges[i][0] - charges[i-1][0]) // 100
        for j in range(charges[i][0] - charges[i-1][0], 1000+1):
            if dp[i-1][j] < float('inf'):
                dp[i][j- charges[i][0] + charges[i-1][0]] = dp[i-1][j] + driveTime

        if min(dp[i][:1000]) == float('inf'):
            print(-1)
            return

        
            


def func():
    D = int(input())
    N = int(input())
    charges = []
    for _ in range(N):
        charges.append(list(map(int,input().split())))

    if D <= 1000:
        print(D // 100)
        return


    ans = float('inf')

    cache = {}

    def dfs(i, power, time):
        nonlocal ans
        # print(i, power, time, cur)
        cur = charges[i][0]
        if cur + power >= D:
            ans = min(ans, time + (D - cur) // 100)
            return

        if cur + 1000 >= D:
            ans = min(ans, time + charges[i][1] + 1 + (D - cur) // 100)
            # return

        if time >= ans:
            return

        if i + 1 < len(charges):
            driveTime = (charges[i+1][0] - charges[i][0]) // 100
            if power >= charges[i+1][0] - charges[i][0]:
                dfs(i+1, power - charges[i+1][0] + charges[i][0], time + driveTime, charges[i+1][0])
            dfs(i+1, 1000 - charges[i+1][0] + charges[i][0], time + charges[i][1] + 1 + driveTime, charges[i+1][0])
            

    dfs(0, 1000 - charges[0][0], charges[0][0] // 100, charges[0][0])
    print(ans if ans < float('inf') else -1)

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    # please finish the function body here.
    # please define the python3 output here. For example: print().

if __name__ == "__main__":
    func()
