# 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV15FZuqAL4CFAYD&categoryId=AV15FZuqAL4CFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

code = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011']

result = []
for _ in range(T):
    n, m = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.append(input())

    for i in range(n):
        if arr[i] != '0' * m:
            one_line = arr[i]
            break

    for i in range(1, m+1):
        if one_line[-i] == '1':
            start = m-i-55
            end = m-i+1
            pw = one_line[start:end]
            break

    num = []
    for i in range(1, 9):
        start = (i - 1) * 7
        end = i * 7
        temp = code.index(pw[start:end])
        num.append(temp)

    possible = 0
    for i in range(1, 9):
        if i % 2 != 0:
            possible += num[i-1] * 3
        else:
            possible += num[i-1]
    ans = 0
    if possible % 10 == 0:
        ans = sum(num)

    result.append(ans)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))