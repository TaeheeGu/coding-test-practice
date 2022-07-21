#2071번 평균값 구하기
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())

result = []

for i in range(T):
    total_sum = sum(list(map(int, input().split())))
    avg = round(total_sum / 10)
    result.append(avg)

for i in range(T):
  print("#%d %d" % ((i + 1), result[i]))
