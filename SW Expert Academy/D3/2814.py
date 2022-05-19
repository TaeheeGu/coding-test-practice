# 2814. 최장 경로 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV7GOPPaAeMDFAXB&categoryId=AV7GOPPaAeMDFAXB&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

T = int(input())

for t in range(T):
    vertex, edge = map(int, input().split())
    graph = [[] for _ in range(vertex + 1)]

    for i in range(edge):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    result = 0

    for i in range(1, vertex + 1):
        visited = [False] * (vertex + 1)

        def dfs(v, count):
            global result
            visited[v] = True
            result = max(result, count)
            for x in graph[v]:
                if not visited[x]:
                    dfs(x, count+1)
                    visited[x] = False

        dfs(i, 1)

    print("#{} {}".format((t+1), result))
