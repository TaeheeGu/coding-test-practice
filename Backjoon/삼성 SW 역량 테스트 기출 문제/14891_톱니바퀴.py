#14891번 톱니바퀴
#https://www.acmicpc.net/problem/14891

import sys

input = sys.stdin.readline

circle = [0] * 5
for i in range(1, 5):
  circle[i] = input().rstrip()

k = int(input())

arr = []
for i in range(k):
  num, dir = map(int, input().split())
  arr.append((num, dir))

def rotation(circle, num, dir):
  temp = circle[num]
  if dir == 1: #시계방향 회전
    new = temp[7] + temp[:7]
  if dir == -1: #반시계 회전
    new = temp[1:8] + temp[0]
  return new

for i in arr:
  num = i[0]
  dir = i[1]

  right_arr = [] #오른쪽에서 회전할 톱니 번호, 방향
  left_arr = []
  
  right_num = num #오른쪽 톱니 회전 여부
  left_num = num #왼쪽 톱니 회전 여부

  right_dir = -dir
  left_dir = -dir
  
  while right_num < 4: #오른쪽 회전 확인
    #회전하기 전 극 확인
    if circle[right_num][2] == circle[right_num+1][6]: #같은 극은 회전 x
      break
    right_arr.append((right_num+1, right_dir)) #회전해야할 번호, 방향 기록
    right_dir = -right_dir
    right_num += 1
    
  while left_num > 1: #왼쪽 회전 확인
    #회전하기 전 극 확인
    if circle[left_num][6] == circle[left_num-1][2]: #같은 극은 회전 x
      break
    left_arr.append((left_num-1, left_dir))  #회전해야할 번호, 방향 기록
    left_dir = -left_dir
    left_num -= 1

  circle[num] = rotation(circle, num, dir) #지정된 톱니 회전
  
  for j in right_arr: #오른쪽 톱니 회전
    num = j[0]
    dir = j[1]
    circle[num] = rotation(circle, num, dir)

  for j in left_arr: #왼쪽 톱니 회전
    num = j[0]
    dir = j[1]
    circle[num] = rotation(circle, num, dir)

result = 0
for i in range(1, 5):
  if circle[i][0] == '1':
    result += 2**(i-1)

print(result)