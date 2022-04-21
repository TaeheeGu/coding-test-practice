#백준 15686번 치킨배달
n, m = map(int, input().split()) #도시크기 n, 남길 치킨 집 m

city = []

for i in range(n):
  line = list(map(int, input().split()))
  city.append(line)

home = [] #집 좌표
chicken = [] #치킨 가게 좌표

#좌표 구하기
for i in range(n):
  for j in range(n):
    if city[i][j] == 1:
      home.append((i+1, j+1))
    if city[i][j] == 2:
      chicken.append((i+1, j+1))


#하나의 치킨 집에서 각 집 까지의 거리
chicken_dsit=[[0] * len(home) for _ in range(len(chicken))]

for i in range(len(chicken)):
  for j in range(len(home)):
    dist = abs(chicken[i][0] - home[j][0]) + abs(chicken[i][1] - home[j][1])
    chicken_dsit[i][j] = dist

    
#리스트에서 조합 구하기
from itertools import combinations

result = 999999

for combination in combinations(chicken_dsit, m):
  temp = 0
  for i in range(len(home)):
    min_dist = 999
    for j in range(m):
      min_dist = min(min_dist, combination[j][i])
    temp += min_dist
  result = min(result, temp)

print(result)
'''
chicken_dsit_sum = []
for i in range(len(chicken_dsit)):
    chicken_dsit_sum.append((i, sum(chicken_dsit[i])))

chicken_dsit_sum.sort(key=lambda x : x[1])


result = 0

for i in range(len(home)):
  min_dist = []
  for j in range(m):
    min_dist.append(chicken_dsit[chicken_dsit_sum[j][0]][i])
  result += min(min_dist)

print(result)
'''