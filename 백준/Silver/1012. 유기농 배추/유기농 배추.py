import sys
sys.setrecursionlimit(10**7) # 재귀한도 확장
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    positions = [tuple(map(int, input().split())) for _ in range(K)]
    matrix = [[0] * M for _ in range(N)]
    
    # 배추의 위치(x, y) -> matrix[y][x]에 1로 표기
    for x, y in positions:
        matrix[y][x] = 1
    
    # 상하좌우 4방향
    dr = [1, 0, -1, 0]
    dc = [0, 1, 0, -1]
    # (r, c)에 인접한 모든 배추 방문처리
    def dfs(r, c):
        # 배추가 심어져 있지 않은 땅이면(종료)
        if matrix[r][c] != 1:
            return
        matrix[r][c] = -1
        # 인접한 4방향 방문처리
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