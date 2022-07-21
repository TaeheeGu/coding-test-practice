# 1225. [S/W 문제해결 기본] 7일차 - 암호생성기 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

T = 10

result = []
for _ in range(T):
    n = int(input())
    pw = list(map(int, input().split()))

    breaker = True
    while breaker:
        for i in range(1, 6):
            temp = pw[0] - i
            if temp <= 0:
                temp = 0
                pw = pw[1:]
                pw.append(temp)
                breaker = False
                break
            pw = pw[1:]
            pw.append(temp)

    answer = ''
    for i in range(8):
        answer += str(pw[i]) + ' '
    result.append(answer.rstrip())

for t in range(T):
    print("#{} {}".format((t+1), result[t]))
