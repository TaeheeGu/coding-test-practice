# 2805. 농작물 수확하기 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

T = int(input())

result = []

for i in range(T):
    n = int(input())
    farm = []
    for _ in range(n):
        farm.append(input())
    price = 0

    for j in range(n // 2):
        for k in range((n // 2) - j, (n // 2) + 1 + j):
            price += int(farm[j][k])
            price += int(farm[-j - 1][k])

    for j in range(n):
        price += int(farm[n//2][j])
    result.append(price)

for i in range(T):
    print("#{} {}".format((i + 1), result[i]))
