#2072 홀수만 더하기
#https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq

t = int(input())

case = []

for i in range(t):
  line = list(map(int, input().split()))
  case.append(line)

for i in range(t):
  problem = case[i]
  result = 0
  for j in range(10):
    if problem[j] % 2 != 0:
      result += problem[j]
  print("#%d %d" %((i+1), result))
