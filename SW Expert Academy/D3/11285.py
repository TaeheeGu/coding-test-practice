# 11285. 다트 게임 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AXZuaLsqz9wDFAST&categoryId=AXZuaLsqz9wDFAST&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=20

T = int(input())

result = []
for t in range(1, T+1):
    n = int(input())
    total_point = 0

    for _ in range(n):
        x, y = map(int, input().split())
        temp = int((x ** 2 + y ** 2) ** 0.5 / 20)
        if temp == 0:
            total_point += 10
        elif temp <= 11:
            total_point += 11 - temp
        print(total_point)
    result.append(total_point)

for i in range(T):
    print("#{} {}".format((i+1), result[i]))
