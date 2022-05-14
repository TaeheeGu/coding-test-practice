# 1954번 달팽이 숫자
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input)

def solve(n):
  dx = [0, 1, 0, -1] #우, 하, 좌, 상
  dy = [1, 0 , -1, 0]
  arr = [[0] * n for _ in range(n)]

  x = 0
  y = 0
  for i in range(1, n*n):
    arr[x][y] = i+1
    if y < n: #오른쪽 이동
      x += dx[0]
      y += dy[0]
    if x < n:
      x += dx[1]
      y += dy[1]