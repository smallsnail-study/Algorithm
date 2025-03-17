import sys
my_input = sys.stdin.readline
N = int(my_input())

pairs = [ list(map(int, my_input().split())) for _ in range(N) ]

output = [0] * N

for i in range(N):
    output[i] = sum(pairs[i])

print(*output, sep="\n")