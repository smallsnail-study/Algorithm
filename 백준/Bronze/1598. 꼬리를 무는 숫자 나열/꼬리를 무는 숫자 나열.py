a, b = map(int, input().split())

col_a = (a - 1) % 4
row_a = (a - 1) // 4

col_b = (b - 1) % 4
row_b = (b - 1) // 4

print(abs(col_a - col_b) + abs(row_a - row_b))