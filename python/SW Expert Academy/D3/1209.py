# 1209. [S/W 문제해결 기본] 2일차 - Sum D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV13_BWKACUCFAYh&categoryId=AV13_BWKACUCFAYh&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

T = 10

result = []
for t in range(T):
    test = int(input())
    testcase = []
    for _ in range(100):
        arr = list(map(int, input().split()))
        testcase.append(arr)

    arr_sum = []
    left_top_sum = 0 #left-top to right-bottom 대각선
    right_top_sum = 0 #right-top to right-bottom 대각선
    for i in range(100):
        row_sum = 0
        col_sum = 0
        left_top_sum += testcase[i][i]
        right_top_sum += testcase[i][-i - 1]
        for j in range(100):
            row_sum += testcase[i][j] #행의 합
            col_sum += testcase[j][i] #열의 합
        arr_sum.append(max(row_sum, col_sum))
    arr_sum.append(max(left_top_sum, right_top_sum))

    result.append(max(arr_sum)) #최대 값 구하기

for t in range(T):
    print("#{} {}".format((t+1), result[t]))