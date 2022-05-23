# 1933. 간단한 N 의 약수 D1
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PhcWaAKIDFAUq&categoryId=AV5PhcWaAKIDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

n = int(input())

result = []
for i in range(1, int(n**0.5)):
    if n % i == 0:
        result.append(i)
        result.append(n // i)
result.sort()

for i in range(len(result)):
    print(result[i], end=' ')