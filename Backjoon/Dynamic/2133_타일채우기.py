#2133번 타일 채우기
#https://www.acmicpc.net/problem/2133

n = int(input())

result=0
dp_table=[0]*31

dp_table[0] = 1

for i in range(2, n+1, 2):
  dp_table[i] = dp_table[i-2] * 3
  for j in range(0, i-2, 2):
    dp_table[i] += dp_table[j] * 2
  
if n%2 != 0:
  print(0) #타일로 벽을 채울 수 없는 경우
else:
  result = dp_table[n]
  print(result)


