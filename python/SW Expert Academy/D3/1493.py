# 1493. 수의 새로운 연산 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV2b-QGqADMBBASw&categoryId=AV2b-QGqADMBBASw&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

find_point = [0, 1]

idx = 2
while True:
    find_point.append(find_point[idx - 1] + (idx - 1))
    if idx > 10000:
        break
    idx += 1

result = []
for _ in range(T):
    p, q = map(int, input().split())

    def solve_1(a):
        start = 0
        x_point = 1
        y_point = 1
        for k in range(1, len(find_point) - 1):
            if find_point[k] <= a < find_point[k + 1]:
                start = find_point[k]
                y_point = k
                break
        x_point = x_point + (a - start)
        y_point = y_point - (a - start)

        return x_point, y_point


    x, y = solve_1(p)
    z, w = solve_1(q)

    new_x = x + z
    new_y = y + w

    ans = find_point[new_x + new_y - 1] + new_x - 1
    result.append(ans)

for t in range(T):
    print("#{} {}".format((t + 1), result[t]))
