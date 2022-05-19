# 1220. [S/W 문제해결 기본] 5일차 - Magnetic D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14hwZqABsCFAYD&categoryId=AV14hwZqABsCFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3


#1은 n극 아래로, 2는 s극 위로
#테이블 윗 부분은 n극, 아래 부분은 s극
T = 10

for t in range(1, T+1):
    table_length = int(input())
    table = []

    for _ in range(table_length):
        table.append(list(map(int, input().split())))

    while True:
        move = False
        for i in range(table_length):
            for j in range(table_length):
                if table[i][j] == 1 and i == table_length-1: #n극이 아래로가서 떨어지는 경우
                    table[i][j] = 0
                    move = True
                if table[i][j] == 2 and i == 0: #s극이 위로가서 떨어지는 경우
                    table[i][j] = 0
                    move = True
                if table[i][j] == 1 and table[i+1][j] == 0: #n극이 아래로
                    table[i][j] = 0
                    table[i+1][j] = 1
                    move = True
                if table[i][j] == 2 and table[i-1][j] == 0: #s극이 위로
                    table[i][j] = 0
                    table[i-1][j] = 2
                    move = True

        if not move:
            break

    count = 0
    for i in range(table_length):
        for j in range(table_length-1):
            if table[j][i] == 1 and table[j+1][i] == 2:
                count += 1

    print("#{} {}".format(t, count))