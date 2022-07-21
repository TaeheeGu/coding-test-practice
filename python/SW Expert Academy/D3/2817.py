# 2817. 부분 수열의 합 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV7IzvG6EksDFAXB&categoryId=AV7IzvG6EksDFAXB&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

T = int(input())

result = []


def solve(idx, curr_sum):
    global count
    temp = curr_sum + seq[idx]

    if temp == k: #조건과 일치할 경우
        count += 1
        return

    if idx == n: #끝까지 탐색한 경우
        if temp == k:  # 조건과 일치할 경우
            count += 1
        return

    if temp > k: #정해진 k 보다 큰 경우 추가되는 조합을 찾을 필요가 없다
        return

    solve(idx + 1, curr_sum) #현재 인덱스의 숫자를 선택하지 않은 경우
    solve(idx + 1, temp) #현재 인덱스의 숫자를 선택하여 합한 경우


for t in range(T):
    n, k = map(int, input().split())
    seq = list(map(int, input().split()))
    count = 0
    solve(0, 0) #0번째 원소부터, 현재 합은 0
    result.append(count)

for t in range(T):
    print("#{} {}".format((t + 1), result[t]))
