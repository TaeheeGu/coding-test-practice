# 1979. 어디에 단어가 들어갈 수 있을까 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PuPq6AaQDFAUq&categoryId=AV5PuPq6AaQDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

T = int(input())


def check(num, length):
    if num == length:
        return 1
    return 0


result = []
for t in range(T):
    n, k = map(int, input().split())
    puzzle = []
    for _ in range(n):
        puzzle.append(list(map(int, input().split())))

    count = 0
    for i in range(n):
        row = 0
        col = 0
        for j in range(n):
            if puzzle[i][j] == 1:
                row += 1
            if puzzle[j][i] == 1:
                col += 1
            if puzzle[i][j] == 0:
                count += check(row, k)
                row = 0
            if puzzle[j][i] == 0:
                count += check(col, k)
                col = 0
        count += check(row, k)
        count += check(col, k)

    result.append(count)

for t in range(T):
    print("#{} {}".format((t + 1), result[t]))
