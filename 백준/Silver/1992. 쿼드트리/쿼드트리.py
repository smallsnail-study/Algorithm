import sys
def is_uniform(matrix, x, y, size):
    first_color = matrix[x][y]

    for i in range(x, x+size):
        for j in range(y, y+size):
            if matrix[i][j] != first_color:
                return -1

    return first_color

def quadtree_compress(matrix, x, y, size):
    state = is_uniform(matrix, x, y, size)
    if state != -1:
        return str(state)

    half = size // 2
    top_left = quadtree_compress(matrix, x, y, half)
    top_right = quadtree_compress(matrix, x, y+half, half)
    bottom_left = quadtree_compress(matrix, x+half, y, half)
    bottom_right = quadtree_compress(matrix, x+half, y+half, half)
    return "(" + top_left + top_right + bottom_left + bottom_right + ")"

n = int(sys.stdin.readline())
matrix = []
for _ in range(n):
    row = list(map(int, sys.stdin.readline().rstrip()))
    matrix.append(row)

result = quadtree_compress(matrix, 0, 0, n)
print(result)