# 1954번 달팽이 숫자
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())

dx = [0, 1, 0, -1]  # 0123
dy = [1, 0, -1, 0]

result = []
for _ in range(T):
    n = int(input())
    arr = [[0] * n for _ in range(n)]

    x = 0
    y = 0
    idx = 0
    for i in range(1, n * n +1):
        arr[x][y] = i
        if y == n-1 and x == 0:
            idx += 1
        if y == n-1 and x == n-1:
            idx += 1
        if y == 0 and x == n-1:
            idx += 1
        if arr[x+dx[idx]][y+dy[idx]] != 0:
            idx += 1
        idx = idx % 4
        x += dx[idx]
        y += dy[idx]

    ans = ''
    for i in range(n):
        for j in range(n):
            ans += str(arr[i][j]) + ' '
        ans += '\n'

    result.append(ans.rstrip())

for t in range(T):
    print("#{}".format(t+1))
    print(result[t])
