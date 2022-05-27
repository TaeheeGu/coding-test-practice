# 1948. 날짜 계산기 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=6

T = int(input())

days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

result = []
for _ in range(T):
    m1, d1, m2, d2 = map(int, input().split())
    ans = 0

    if m1 == m2:
        ans = d2 - d1 + 1
    else:
        ans = days[m1] - d1 + 1
        for i in range(m1 + 1, m2):
            ans += days[i]
        ans += d2

    result.append(ans)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))