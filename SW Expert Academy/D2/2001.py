# 2001. 파리 퇴치 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

T = int(input())

result = []
for i in range(T):
    n, m = map(int, input().split())
    fly = []
    for _ in range(n):
        arr = list(map(int, input().split()))
        fly.append(arr)

    kill = 0
    for x in range(n - m + 1): # 파리채의 영역 접근, 인덱스 계산에 주의
        for y in range(n - m + 1):
            temp = 0
            for a in range(m):
                for b in range(m):
                    temp += fly[x + a][y + b]
            if temp > kill:
                kill = temp

    result.append(kill)

for i in range(T):
    print("#{} {}".format((i + 1), result[i]))
