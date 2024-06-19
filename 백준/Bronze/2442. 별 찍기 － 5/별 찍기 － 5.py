n = int(input())

for i in range(n): # i는 인덱스, 0부터시작
    for j in range(n - i - 1):
        print(' ', end="")
    for j in range(2 * i + 1):
        print('*', end="")
    print()