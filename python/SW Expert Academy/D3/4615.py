# 4615. 재미있는 오셀로 게임 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AWQmA4uK8ygDFAXj&categoryId=AWQmA4uK8ygDFAXj&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6

T = int(input())

for t in range(1, T+1):
    n, m = map(int, input().split())

    board = [[0] * n for _ in range(n)]

    board[n // 2 - 1][n // 2 - 1] = 2
    board[n // 2][n // 2] = 2
    board[n // 2 - 1][n // 2] = 1
    board[n // 2][n // 2 - 1] = 1

    dx = [0, -1, 0, 1, -1, 1, -1, 1] #왼 위 오 아래 왼위 왼아래 오위 오아래
    dy = [-1, 0, 1, 0, -1, -1, 1, 1]

    for _ in range(m):
        y, x, color = map(int, input().split())
        y -= 1
        x -= 1
        board[x][y] = color
        for i in range(8):
            nx = x + dx[i]
            ny = x + dy[i]
            temp = [] #뒤집을 것들
            while True:
                if nx < 0 or nx > n-1 or ny < 0 or ny > n-1:
                    temp = []
                    break
                if board[nx][ny] == 0:
                    temp = []
                    break
                if board[nx][ny] == color:
                    break
                else:
                    temp.append((nx, ny))
                nx += dx[i]
                ny += dy[i]
            for rx, ry in temp:
                board[rx][ry] = color
    W = 0
    B = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                W += 1
            elif board[i][j] == 2:
                B += 1

    print("#{} {} {}".format(t, W, B))
