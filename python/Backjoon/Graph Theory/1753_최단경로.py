#백준 1753번 최단 경로
#https://www.acmicpc.net/problem/1753

#주어진 시작점에서 다른 모든 정점으로의 최단 경로
#다익스트라 알고리즘 시간복잡도 O(ElogV)

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9) #경로가 존재하지 않는 경우, 무한, 10억

v, e = map(int, input().split()) #정점의 개수 v, 간선의 개수 e
k = int(input()) #시작점

graph = [[] for _ in range(v+1)] #각 노드에 연결된 노드에 대한 정보
distance = [INF] * (v+1) #최단 거리 테이블 무한으로 초기화

for i in range(e):
  start, end, weight = map(int, input().split()) #u에서 v로 가는 가중치 w
  graph[start].append((end, weight))

def dijkstra(start):
  q = [] #우선순위 큐
  heapq.heappush(q, (0, start)) #시작노드로 가는 최단 거리 0, 큐에 삽입
  distance[start] = 0 #시작 노드에서 시작 노드로 거리 0

  while q:
    dist, now = heapq.heappop(q) #가장 최단 거리가 짧은 노드 정보 큐에서 꺼내기

    if distance[now] < dist: #이미 처리된 노드까지 거리가 큐의 최단거리 보다 짧은 경우
      continue #처리된 노드 넘어간다

    for i in graph[now]: #현재 노드와 연결된 다른 인접 노드
      cost = dist + i[1] #현재 노드 거쳐 인접 노드로 가는 비용
      if cost < distance[i[0]]: #현재 노드를 거쳐가는 경우가 더 짧은 경우
        distance[i[0]] = cost #최단 거리 갱신
        heapq.heappush(q, (cost, i[0])) #갱신된 노드 정보(거리, 번호) 큐 삽입

dijkstra(k)

for i in range(1, v+1):
  if distance[i] == INF:
    print('INF')
  else:
    print(distance[i])