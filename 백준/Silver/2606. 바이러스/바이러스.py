import sys
sys.setrecursionlimit(10**4)
input = sys.stdin.readline

N = int(input())
T = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(T):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)
def dfs(cur):
    visited[cur] = True
    total = 1
    for next in graph[cur]:
        if not visited[next]:
            total += dfs(next)
    return total
            
count = dfs(1) - 1
print(count)