# 1234. [S/W 문제해결 기본] 10일차 - 비밀번호 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14_DEKAJcCFAYD&categoryId=AV14_DEKAJcCFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6

T = 10

result = []
for _ in range(T):
    n, pw = input().split()

    breaker = True
    while breaker:
        breaker = False
        for i in range(len(pw)-1):
            if pw[i] == pw[i+1]:
                pw = pw[:i] + pw[i+2:]
                breaker = True
                break
    result.append(pw)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))