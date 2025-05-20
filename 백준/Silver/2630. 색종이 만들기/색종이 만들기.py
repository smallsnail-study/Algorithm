import sys

def check_colors(matrix, x, y, size):
    first_color = matrix[x][y]

    for i in range(x, x+size):
        for j in range(y, y+size):
            if matrix[i][j] != first_color:
                return 'mixed'

    if first_color == 0:
        return 'white'
    else:
        return 'blue'

def count_colors(matrix, x, y, size):
    state = check_colors(matrix, x, y, size)

    if state == 'white':
        return (1, 0)
    elif state == 'blue':
        return (0, 1)

    half = size // 2
    w1, b1 = count_colors(matrix, x, y, half)
    w2, b2 = count_colors(matrix, x, y+half, half)
    w3, b3 = count_colors(matrix, x+half, y, half)
    w4, b4 = count_colors(matrix, x+half, y+half, half)
    total_white = w1 + w2 + w3 + w4
    total_blue = b1 + b2 + b3 + b4
    return (total_white, total_blue)

n = int(sys.stdin.readline())
matrix = []
for _ in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    matrix.append(row)

total_white_counts, total_blue_counts = count_colors(matrix, 0, 0, n)
print(total_white_counts)
print(total_blue_counts)