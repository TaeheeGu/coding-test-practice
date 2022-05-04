#1206번 [S/W 문제해결 기본] 1일차 - View
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

t = 10

answer = []

for i in range(t):
  n = int(input())
  height = list(map(int, input().split()))

  result = 0
  for j in range(2, n-2):
    left = height[j] - max(height[j-1], height[j-2])
    right = height[j] - max(height[j+1], height[j+2])
    if left > 0 and right > 0:
      result = min(left, right)

  answer.append(result)

for i in range(t):
  print("#%d %d" %(i+1, answer[i]))
    