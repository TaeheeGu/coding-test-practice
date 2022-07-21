# 1859번 백만 장자 프로젝트
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

t = int(input())

answer = []

for i in range(t):
    n = int(input())
    price = list(map(int, input().split()))

    best_price = price[-1]
    result = 0
    for j in range(2, n + 1):

        if best_price > price[-j]:
            result += (best_price - price[-j])
        elif best_price < price[-j]:
            best_price = price[-j]

    answer.append(result)

for i in range(t):
    print("#%d %d" % (i + 1, answer[i]))
