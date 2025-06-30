import sys
sys.setrecursionlimit(10**4)
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    positions = [tuple(map(int, input().split())) for _ in range(K)]
    matrix = [[0] * M for _ in range(N)]
    
    for x, y in positions:
        matrix[y][x] = 1
    
    dr = [1, 0, -1, 0]
    dc = [0, 1, 0, -1]
    def dfs(r, c):
        if matrix[r][c] != 1:
            return
        matrix[r][c] = -1
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < N and 0 <= nc < M:
                dfs(nr, nc)
                
    cnt = 0
    for i in range(N):
        for j in range(M):
            if matrix[i][j] == 1:
                cnt += 1
                dfs(i, j)
    print(cnt)