#1260번 DFS와 BFS
#https://www.acmicpc.net/problem/1260

import sys
from collections import deque #너비 우선 탐색위한 큐

input = sys.stdin.readline

n, m, v = map(int, input().split())  #정점의 개수 n, 간선의 개수 m

graph = [[] for _ in range(n + 1)]

for i in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)
  graph[a].sort() #작은 번호의 정점부터 탐색
  graph[b].sort()

result_dfs = []
result_bfs = []

visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)

#깊이 우선 탐색
def dfs(graph, v, visited):
  visited[v] = True
  result_dfs.append(v)
  #현재 노드와 연결된 다른 노드 재귀적 방문
  for i in graph[v]:  #현재 노드 v 인접 노드 탐색
    if not visited[i]:
      dfs(graph, i, visited)
          
#너비 우선 탐색
def bfs(graph, v, visited):
  q = deque([v])  #큐
  visited[v] = True  #현재 노드 방문 처리
  while q:  #큐가 빌 때까지 반복
    v = q.popleft()  #큐에서 출력, 선입선출
    result_bfs.append(v)
    for i in graph[v]:
      if not visited[i]:
        q.append(i)
        visited[i] = True

dfs(graph, v, visited_dfs)
bfs(graph, v, visited_bfs)

for i in result_dfs:
    print(i, end=" ")
print()
for i in result_bfs:
    print(i, end=" ")
