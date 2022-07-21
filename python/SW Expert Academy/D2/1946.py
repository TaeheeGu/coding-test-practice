# 1946. 간단한 압축 풀기 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PmkDKAOMDFAUq&categoryId=AV5PmkDKAOMDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

result = []
for _ in range(T):
    n = int(input())
    temp = ''
    for _ in range(n):
        c, k = input().split()
        temp += c * int(k)

    ans = ''
    for i in range(1, len(temp)+1):
        ans += temp[i-1]
        if i % 10 == 0:
            ans += '\n'

    result.append(ans)

for t in range(T):
    print("#{}".format(t+1))
    print(result[t])

