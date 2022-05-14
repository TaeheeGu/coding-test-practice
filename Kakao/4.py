def solution(n, paths, gates, summits):
    answer = []
    result = []
    graph = [[] for _ in range(n)]

    for i in range(len(paths)):
        graph[paths[i][0]].append(paths[i][1])
        graph[paths[i][1]].append(paths[i][0])

    for v in gates:
        for i in range(len(summits)):
            visited = [False] *(n+1)
            weight = int(1e9)
            visited[v] = True
            end = summits[i]
            block = summits[i-1:i-3]
            answer = dfs(graph, v, visited, end, block, course):

    return answer


def dfs(graph, v, visited, end, block, course):
    visited[v] = True
    course.append(v)
    if v == end:
        return course
    for i in graph[v]:
        if not visited[i] and i not in block:
            course.append(i)
            dfs(graph, v, visited, end, block) 
            visited[i] = False
            course.pop()