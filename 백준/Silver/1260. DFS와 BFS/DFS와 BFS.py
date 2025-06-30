import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for lst in graph:
    lst.sort()
    
visited = [False] * (N + 1)
dfs_order = []
def dfs(cur):
    visited[cur] = True
    dfs_order.append(cur)
    for next in graph[cur]:
        if not visited[next]:
            dfs(next)
dfs(V)

visited = [False] * (N + 1)
bfs_order = []
def bfs(start):
    q = deque([start])
    visited[start] = True
    while q:
        cur = q.popleft()
        bfs_order.append(cur)
        for next in graph[cur]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
bfs(V)

print(*dfs_order)
print(*bfs_order)