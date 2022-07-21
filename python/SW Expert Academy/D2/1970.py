# 1970. 쉬운 거스름돈 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

T = int(input())

changes = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

result = []
for _ in range(T):
    n = int(input())

    ans = [0]*8
    for i in range(8):
        ans[i] = n // changes[i]
        n = n % changes[i]

    answer = ''
    for i in ans:
        answer += str(i) + ' '
    result.append(answer.rstrip())

for t in range(T):
    print("#{}".format(t+1))
    print(result[t])