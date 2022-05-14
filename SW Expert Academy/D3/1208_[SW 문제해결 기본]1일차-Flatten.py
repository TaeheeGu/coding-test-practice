#1208. [S/W 문제해결 기본] 1일차 - Flatten
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1


## 정렬을 이용한 풀이(min, max 내장 함수 가능)
# T = int(input())
T = 10

dump = []
boxes = []

for i in range(T):
  dump.append(int(input()))
  box = list(map(int, input().split()))
  box.sort(reverse=True)
  boxes.append(box)

def solve(box, count):
  result = box[0] - box[-1]
  for i in range(count):
    box[0] -= 1
    box[-1] += 1
    box.sort(reverse=True)
    if result == 0 or result == 1:
      break
    result = box[0] - box[-1]
  return result

for i in range(T):
  result = solve(boxes[i], dump[i])
  print("#%d %d" %((i+1), result))