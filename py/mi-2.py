s = input().strip()
t = input().strip()
m,n=len(s),len(t)

dp = [[501 for _ in range(n+1)] for _ in range(m+1)]
dp[0][0] = 0

for i in range(n+1):
    dp[0][i] = i

for i in range(m+1):
    dp[i][0] = i

for i in range(1,m+1):
    for j in range(1,n+1):
        if s[i-1] == t[j-1]:
            dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])+1)
        else:
            dp[i][j] = min(dp[i-1][j], dp[i][j-1],dp[i-1][j-1])+1

        # print(i,j,dp[i][j])

if n == 0 or m == 0:
    print(max(m,n))
elif s == t:
    print(0)
else:
    print(dp[m][n])