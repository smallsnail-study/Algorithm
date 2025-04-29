n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]
b = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    result_row = []
    for j in range(m):
        result_row.append(a[i][j] + b[i][j])
    
    print(' '.join(map(str, result_row)))