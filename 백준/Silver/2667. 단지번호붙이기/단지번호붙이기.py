import sys
input = sys.stdin.readline
N = int(input())
matrix = [list(map(int, input().strip())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
answers = []

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def dfs(y, x):
    visited[y][x] = True
    count = 1
    
    for dir in range(4):
        ny = y + dy[dir]
        nx = x + dx[dir]
        if 0 <= ny < N and 0 <= nx < N:
            if not visited[ny][nx] and matrix[ny][nx] == 1:
                count += dfs(ny, nx)
    return count

for y in range(N):
    for x in range(N):
        if matrix[y][x] == 1 and not visited[y][x]:
            size = dfs(y, x)
            answers.append(size)

answers.sort()
print(len(answers))
print(*answers, sep = "\n")