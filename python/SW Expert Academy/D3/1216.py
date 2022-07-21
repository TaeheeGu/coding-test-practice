# 1216. [S/W 문제해결 기본] 3일차 - 회문2 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14Rq5aABUCFAYi&categoryId=AV14Rq5aABUCFAYi&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

for t in range(10):
    test_number = int(input())

    board = []

    for _ in range(100):
        board.append(input())

    row_max = 0
    for i in range(100):
        for j in range(100):
            for k in range(100-j):
                row_string = board[i][j:101-k]
                if row_string == row_string[::-1]:
                    row_max = max(row_max, len(row_string))
                    break

    col_max = 0
    for i in range(100):
        for j in range(100):
            col_string = ''
            for k in range(100-j):
                col_string += board[j+k][i]
                if col_string == col_string[::-1]:
                    col_max = max(col_max, len(col_string))

    result = max(row_max, col_max)

    print("#{} {}".format(test_number, result))
