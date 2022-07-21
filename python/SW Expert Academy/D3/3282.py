# 3282. 0/1 Knapsack D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AWBJAVpqrzQDFAWr&categoryId=AWBJAVpqrzQDFAWr&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6

T = int(input())

result = []
for _ in range(T):
    n, k = map(int, input().split())
    volume = []
    cost = []
    for _ in range(n):
        v, c = map(int, input().split())
        volume.append(v)
        cost.append(c)

    dp = [[0] * (k+1) for _ in range(n+1)] # 행(0 ~ n) * 열(0 ~ k)

    for i in range(1, n+1):
        for j in range(1, k+1):
            if j >= volume[i - 1]:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-volume[i - 1]] + cost[i - 1])
            else:
                dp[i][j] = dp[i-1][j]

    max_cost = dp[n][k]
    result.append(max_cost)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))
