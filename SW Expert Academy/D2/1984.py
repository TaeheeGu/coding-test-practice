# 1984. 중간 평균값 구하기 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())

result = []
for _ in range(T):
    arr = list(map(int, input().split()))

    ans = 0
    for num in arr:
        if num == max(arr) or num == min(arr):
            continue
        ans += num

    ans /= (len(arr) - 2)
    ans = round(ans)
    result.append(ans)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))