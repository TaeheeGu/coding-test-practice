# 5215. 햄버거 다이어트 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=5

T = int(input())


def solve(idx, score, cal):
    global max_score

    if cal > limit:
        return

    if idx >= n:
        if score > max_score:
            max_score = score
        return

    temp_score = score + t_arr[idx]
    temp_cal = cal + k_arr[idx]

    solve(idx + 1, temp_score, temp_cal)  # 선택된 재료를 포함하는 경우
    solve(idx + 1, score, cal)  # 선택된 재료를 포함하지 않는 경우우


result = []
for _ in range(T):
    n, limit = map(int, input().split())
    t_arr = []
    k_arr = []
    for _ in range(n):
        t, k = map(int, input().split())
        t_arr.append(t)
        k_arr.append(k)

    max_score = 0

    solve(0, 0, 0)

    result.append(max_score)

for t in range(T):
    print("#{} {}".format((t + 1), result[t]))
