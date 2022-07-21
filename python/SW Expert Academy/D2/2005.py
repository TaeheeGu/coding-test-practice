# 2005. 파스칼의 삼각형 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

T = int(input())

testcase = []
for i in range(T):
    n = int(input())
    testcase.append(n)

for i in range(T):
    n = testcase[i]
    result = [[0] * n for _ in range(n)]
    result[0][0] = 1
    for j in range(1, n):
        for k in range(j+1):
            result[j][k] = result[j-1][k-1] + result[j-1][k]  #출력 형태에 따라 왼쪽 위 오른쪽 위 접근

    print("#{}".format((i+1)))
    for j in range(n):
        for k in range(n):
            if result[j][k] != 0:
                print(result[j][k], end=' ')
        print()