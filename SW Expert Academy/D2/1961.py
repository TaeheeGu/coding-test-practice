# 1961. 숫자 배열 회전 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

T = int(input())


def rotate_90(array):
    new_arr = []
    for col in range(len(array)):
        line = ''
        for row in range(1, len(array) + 1):
            line += str(array[-row][col])
        new_arr.append(line)
    return new_arr


result = []

for t in range(T):
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))

    answer = []
    for _ in range(3):
        arr = rotate_90(arr)
        answer.append(arr)

    ans = ''
    for i in range(n):
        for j in range(3):
            ans += answer[j][i]
            if j != 2:
                ans += ' '
        if i != n-1:
            ans += '\n'

    result.append(ans)

for t in range(T):
    print("#{}".format(t+1))
    print(result[t])

