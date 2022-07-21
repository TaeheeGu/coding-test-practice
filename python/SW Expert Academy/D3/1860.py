# 1860. 진기의 최고급 붕어빵 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5LsaaqDzYDFAXc&categoryId=AV5LsaaqDzYDFAXc&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

result = []
for _ in range(T):
    n, m, k = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()

    fish = [0] * (max(arr) + 1) # 손님이 도착할 최대 시간까지 생성되는 붕어빵 dp 테이블
    for i in range(1, len(fish)):
        fish[i] = i // m * k

    ans = 'Possible'
    customer = 0

    for i in range(n):
        customer = arr[i]
        if fish[customer] == 0:
            ans = 'Impossible'
            break
        else:
            for j in range(customer, len(fish)):
                fish[j] -= 1

    result.append(ans)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))