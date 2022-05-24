# 1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14dUIaAAUCFAYD&categoryId=AV14dUIaAAUCFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = 10


def square(a, cnt):
    global num
    if cnt > m:
        return
    num *= a
    square(a, cnt + 1)


result = []
for t in range(T):
    testcase = int(input())
    n, m = map(int, input().split())
    num = 1
    square(n, 1)
    result.append("#{} {}".format(testcase, num))

for t in range(T):
    print(result[t])
