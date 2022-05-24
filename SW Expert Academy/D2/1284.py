# 1284. 수도 요금 경쟁 D2 Attack
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV189xUaI8UCFAZN&categoryId=AV189xUaI8UCFAZN&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

result = []
for _ in range(T):
    p, q, r, s, w = map(int, input().split())

    price_a = p * w
    if w <= r:
        price_b = q
    else:
        price_b = q + (w - r) * s

    if price_a < price_b:
        result.append(price_a)
    else:
        result.append(price_b)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))