arr = []

for _ in range(9):
    row = list(map(int, input().split()))
    arr.append(row)

max = -1
position = [0, 0]

for i in range(9):
    for j in range(9):
        if arr[i][j] > max:
            max = arr[i][j]
            position = [i+1, j+1]

print(max)
print(position[0], position[1])