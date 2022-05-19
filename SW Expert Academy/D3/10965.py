# 10965. 제곱수 만들기 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AXWXH_h695kDFAST&categoryId=AXWXH_h695kDFAST&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=20

T = int(input())

for t in range(1, T+1):
    n = int(input())
    d = 2
    # dp = [0] * (n+1) #너무 오래 걸린다.
    while n != 1:
        if n % d == 0:
            n = n // d
            dp[d] += 1
        else:
            d += 1

    answer = 1

    for i in range(len(dp)):
        if dp[i] % 2 != 0:
            answer *= i

    if answer == 1:
        answer *= n

    print("#{} {}".format(t, answer))
