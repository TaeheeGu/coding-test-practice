# 2806. N-Queen
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV7GKs06AU0DFAXB&categoryId=AV7GKs06AU0DFAXB&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())

testcase = []

for i in range(T):
    testcase.append(int(input()))


def is_promising(x):
    for i in range(x):
        if rows[x] == rows[i] or abs(rows[x] - rows[i]) == abs(x - i):
            return False
    return True


def solve(x):
    global result
    if x == n:
        result += 1
        return

    for i in range(n):
        rows[x] = i
        if is_promising(x):
            solve(x + 1)


for i in range(T):
    n = testcase[i]
    rows = [0] * n
    result = 0
    solve(0)
    print("#%d %d" % ((i + 1), result))
