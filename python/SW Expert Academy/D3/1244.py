# 1244번 [S/W 문제해결 응용] 2일차 - 최대 상금
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())

result = []


def solve(cnt):
    global max_cost

    if cnt >= count: # 교환 횟수를 채운 경우
        temp = int(''.join(board))
        if temp > max_cost:
            max_cost = temp
        return

    for i in range(length):
        for j in range(i + 1, length):
            board[i], board[j] = board[j], board[i]  # 교환
            temp = ''.join(board)
            if not visited.get((temp, cnt + 1)): # 방문한적이 없는 경우
                visited[(temp, cnt + 1)] = True # 방문여부 체크
                solve(cnt + 1) # 다음 교환으로
            board[i], board[j] = board[j], board[i] # 원래대로


result = []
for _ in range(T):
    board, count = input().split()
    count = int(count)
    board = list(board) # 교환 용이 위해 리스트로
    length = len(board)
    visited = {} # 중복 확인을 위한 딕셔너리 key는 (교환값, 교환횟수)
    max_cost = 0 # 최대 상금
    solve(0)

    result.append(max_cost)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))
