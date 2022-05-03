#13460번 구슬 탈출 2
#https://www.acmicpc.net/problem/13460

n, m = map(int, input().split()) #보드의 크기 n * m

board = []

for i in range(n):
  row = list(input().split())
  board.append(row)

for i in range(n):
  for j in range(m):
    if board[i][j] == 'R':
      red_x = i
      red_y = j
    if board[i][j] == 'B':
      blue_x = i
      blue_y = j
    if board[i][j] == 'O':
      out_x = i
      out_y = j

